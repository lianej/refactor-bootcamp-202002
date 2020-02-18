package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private static final double DISCOUNT_RATE = 0.02;
    private static final int NO_DISCOUNT = 0;
    private List<LineItem> lineItems;
    private LocalDate createDate;

    public Order(LocalDate createDate, List<LineItem> lineItems) {
        this.createDate = createDate;
        this.lineItems = lineItems;
        this.lineItems.forEach(item->item.setDiscountRate(getDiscountRate()));
    }

    private double getDiscountRate() {
        return isDiscountDay() ? DISCOUNT_RATE : NO_DISCOUNT;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalAmountIncludeTax() {
        return getLineItems().stream().mapToDouble(LineItem::getTotalAmount).sum() + getTotalSalesTax() - getTotalDiscountAmount();
    }
    public double getTotalDiscountAmount() {
        return getLineItems().stream().mapToDouble(LineItem::getDiscount).sum();
    }

    public double getTotalSalesTax() {
        return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public boolean isDiscountDay(){
        return createDate.getDayOfWeek().getValue() == 3;
    }
}
