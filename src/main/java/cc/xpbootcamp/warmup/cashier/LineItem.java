package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private static final double TAX_RATE = 0.10d;
    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    double getSalesTax() {
        return totalAmount() * TAX_RATE;
    }
}