package aye.domain.shoppingCart;

import aye.domain.catalogue.Product;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        if (product.hasEnoughStock()) {
            this.quantity = quantity;
        }
    }

    public int getTotalPrice() {
        return product.getPrice() * getQuantity();
    }
}
