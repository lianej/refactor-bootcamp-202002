package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private static final double TAX_RATE = 0.10d;
    private String description;
    private double price;
    private int quantity;
    private double discountRate;

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscount(){
        return (this.getTotalAmount() + this.getSalesTax()) * discountRate;
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

    public double getTotalAmount() {
        return getPrice() * getQuantity();
    }

    double getSalesTax() {
        return getTotalAmount() * TAX_RATE;
    }

}