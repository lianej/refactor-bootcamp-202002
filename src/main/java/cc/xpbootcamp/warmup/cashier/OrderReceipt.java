package cc.xpbootcamp.warmup.cashier;

import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    public static final String NEWLINE = "\n";
    public static final String TAB = "\t";
    public static final String PRINTING_TITLE = "======Printing Orders======";
    public static final String SALES_TAX_TITLE = "Sales Tax";
    public static final String TOTAL_AMOUNT_TITLE = "Total Amount";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return getHeaderPrinting() + getItemRowsPrinting() + getSalesTaxPrinting() + getTotalAmountPrinting();
    }

    private String getTotalAmountPrinting() {
        return StringUtils.joining(TAB, TOTAL_AMOUNT_TITLE, order.getTotalAmountIncludeTax());
    }

    private String getSalesTaxPrinting() {
        return StringUtils.joining(TAB, SALES_TAX_TITLE, order.getTotalSalesTax());
    }

    private String getItemRowsPrinting() {
        return order.getLineItems().stream().map(this::printItemRow).collect(Collectors.joining());
    }

    private String printItemRow(LineItem lineItem) {
        String row = StringUtils.joining(TAB,
                lineItem.getDescription(),
                lineItem.getPrice(),
                lineItem.getQuantity(),
                lineItem.totalAmount());
        return row + NEWLINE;
    }

    private String getHeaderPrinting() {
        return PRINTING_TITLE + NEWLINE +
                order.getCustomerName() +
                order.getCustomerAddress() +
                NEWLINE;
    }
}