package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderReceiptTest {

    @Test
    public void should_print_receipt_given_items_and_date_not_discount_day() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", new BigDecimal("21.5"), 2));
            add(new LineItem("小白菜", new BigDecimal("10"), 1));
        }};

        Order order = new Order(LocalDate.parse("2020-02-17"), lineItems);
        OrderReceipt receipt = new OrderReceipt(order);

        String exceptResult =
                "===== 老王超市，值得信赖 ======\n" +
                "\n" +
                "2020年2月17日，星期一\n" +
                "\n" +
                "巧克力, 21.50 x 2, 43.00\n" +
                "小白菜, 10.00 x 1, 10.00\n" +
                "-----------------------------------\n" +
                "税额:   5.30\n" +
                "总价:   58.30\n";

        assertEquals(exceptResult, receipt.printReceipt());
    }

    @Test
    public void should_print_receipt_given_items_and_date_is_wednesday() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", new BigDecimal("21.5"), 2));
            add(new LineItem("小白菜", new BigDecimal("10"), 1));
        }};

        Order order = new Order(LocalDate.parse("2020-02-19"), lineItems);
        OrderReceipt receipt = new OrderReceipt(order);

        String exceptResult =
                "===== 老王超市，值得信赖 ======\n" +
                "\n" +
                "2020年2月19日，星期三\n" +
                "\n" +
                "巧克力, 21.50 x 2, 43.00\n" +
                "小白菜, 10.00 x 1, 10.00\n" +
                "-----------------------------------\n" +
                "税额:   5.30\n" +
                "折扣:   1.17\n" +
                "总价:   57.13\n";
        assertEquals(exceptResult, receipt.printReceipt());
    }



}