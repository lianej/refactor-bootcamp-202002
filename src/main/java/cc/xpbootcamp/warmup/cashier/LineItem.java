package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;

public class LineItem {
    private String description;
    private BigDecimal price;
    private Integer quantity;

    public LineItem(String description, BigDecimal price, Integer quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalAmount() {
        return getPrice().multiply(new BigDecimal(getQuantity()));
    }
}