package aye.utils;

public class SimplifiedCart {
    private String productName;
    private int quantity;

    public SimplifiedCart() {}

    public SimplifiedCart(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }
}
