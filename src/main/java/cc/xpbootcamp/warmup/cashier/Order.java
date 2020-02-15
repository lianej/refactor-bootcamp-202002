package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
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
        return getLineItems().stream().mapToDouble(LineItem::totalAmount).sum() + getTotalSalesTax();
    }

    public double getTotalSalesTax() {
        return getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
    }
}
