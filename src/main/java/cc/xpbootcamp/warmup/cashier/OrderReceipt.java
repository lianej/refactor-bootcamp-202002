package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
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
        StringBuilder output = new StringBuilder();

        printHeader(output);
        printItems(output);
        printSalesTax(output);
        printTotalAmount(output);

        return output.toString();
    }

    private void printTotalAmount(StringBuilder output) {
        output.append(TOTAL_AMOUNT_TITLE).append(TAB).append(order.getTotalAmountIncludeTax());
    }

    private void printSalesTax(StringBuilder output) {
        output.append(SALES_TAX_TITLE).append(TAB).append(order.getTotalSalesTax());
    }

    private void printItems(StringBuilder output) {
        order.getLineItems().stream().map(LineItem::printOrderItemRow).forEach(output::append);
    }

    private void printHeader(StringBuilder output) {
        output.append(PRINTING_TITLE).append(NEWLINE);
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

}