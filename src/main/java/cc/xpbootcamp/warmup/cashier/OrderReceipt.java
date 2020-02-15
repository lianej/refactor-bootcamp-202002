package cc.xpbootcamp.warmup.cashier;

import java.util.stream.Collectors;

public class OrderReceipt {
    private static final String NEWLINE = "\n";
    private static final String TAB = "\t";
    private static final String PRINTING_TITLE = "======Printing Orders======";
    private static final String SALES_TAX_TITLE = "Sales Tax";
    private static final String TOTAL_AMOUNT_TITLE = "Total Amount";
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