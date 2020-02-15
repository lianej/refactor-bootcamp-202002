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

        // print headers
        output.append(PRINTING_TITLE).append(NEWLINE);

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        order.getLineItems().stream().map(LineItem::printOrderItemRow).forEach(output::append);
        double totalSalesTax = order.getLineItems().stream().mapToDouble(LineItem::getSalesTax).sum();
        double totalAmountIncludeTax = order.getLineItems().stream().mapToDouble(LineItem::totalAmount).sum() + totalSalesTax;

        // prints the state tax
        output.append(SALES_TAX_TITLE).append(TAB).append(totalSalesTax);

        // print total amount
        output.append(TOTAL_AMOUNT_TITLE).append(TAB).append(totalAmountIncludeTax);
        return output.toString();
    }

}