package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private String customerName;
    private String address;
    private List<LineItem> lineItems;
    private LocalDate createDate;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public Order(LocalDate createDate, List<LineItem> lineItems) {
        this.createDate = createDate;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalAmountIncludeTax() {
        return getLineItems().stream().mapToDouble(LineItem::getTotalAmount).sum() + getTotalSalesTax();
    }

    public double getTotalSalesTax() {
        return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}
