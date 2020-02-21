package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

public class OrderReceipt {
    private static final String NEWLINE = "\n";
    private static final String PRINTING_TITLE = "===== 老王超市，值得信赖 ======";
    private static final String SALES_TAX_TITLE = "税额:   ";
    private static final String DISCOUNT_TITLE = "折扣:   ";
    private static final String TOTAL_AMOUNT_TITLE = "总价:   ";
    private static final String SEPARATION_LINE = "-----------------------------------";
    private static final String PRICE_PATTERN = "#.00";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy年M月d日，EEEE", Locale.CHINA);

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return getHeaderPrinting() + getItemRowsPrinting() + getAmountPrinting();
    }

    private String getAmountPrinting() {
        return getSalesTaxPrinting() + getDiscountAmountPrinting() + getTotalAmountPrinting();
    }

    private String getTotalAmountPrinting() {
        return TOTAL_AMOUNT_TITLE + formatPrice(order.getFinalAmount()) + NEWLINE;
    }

    private String getDiscountAmountPrinting() {
        if (order.getTotalDiscountAmount() > 0) {
            return DISCOUNT_TITLE + formatPrice(order.getTotalDiscountAmount()) + NEWLINE;
        } else {
            return "";
        }
    }

    private String getSalesTaxPrinting() {
        return SALES_TAX_TITLE + formatPrice(order.getTotalSalesTax()) + NEWLINE;
    }

    private String formatPrice(double price) {
        return new DecimalFormat(PRICE_PATTERN).format(price);
    }

    private String getItemRowsPrinting() {
        return order.getLineItems().stream().map(this::printItemRow).collect(Collectors.joining()) +
                SEPARATION_LINE + NEWLINE;
    }

    private String printItemRow(LineItem item) {
        return item.getDescription() + ", " + formatPrice(item.getPrice()) + " x " + item.getQuantity() + ", " + formatPrice(item.getTotalAmount()) + NEWLINE;
    }

    private String getHeaderPrinting() {
        return PRINTING_TITLE + NEWLINE + NEWLINE +
                DATE_TIME_FORMATTER.format(order.getCreateDate()) + NEWLINE + NEWLINE;
    }
}