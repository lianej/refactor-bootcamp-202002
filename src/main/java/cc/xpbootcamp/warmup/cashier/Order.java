package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.02");
    private static final BigDecimal NO_DISCOUNT = BigDecimal.ZERO;
    private static final BigDecimal TAX_RATE = new BigDecimal("0.1");
    private static final int WEDNESDAY = 3;
    private List<LineItem> lineItems;
    private LocalDate createDate;

    public Order(LocalDate createDate, List<LineItem> lineItems) {
        this.createDate = createDate;
        this.lineItems = lineItems;
    }

    private BigDecimal getDiscountRate() {
        return isDiscountDayOrder() ? DISCOUNT_RATE : NO_DISCOUNT;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public BigDecimal getFinalAmount() {
        return getTotalAmount().add(getTotalSalesTax()).subtract(getTotalDiscountAmount());
    }

    public BigDecimal getTotalAmount() {
        return getLineItems().stream().map(LineItem::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalDiscountAmount() {
        return getTotalAmount().add(getTotalSalesTax()).multiply(getDiscountRate());
    }

    public BigDecimal getTotalSalesTax() {
        return getTotalAmount().multiply(TAX_RATE);
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    private boolean isDiscountDayOrder() {
        return createDate.getDayOfWeek().getValue() == WEDNESDAY;
    }
}
