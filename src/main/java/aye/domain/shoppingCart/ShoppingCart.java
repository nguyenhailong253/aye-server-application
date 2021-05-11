package aye.domain.shoppingCart;

import aye.domain.catalogue.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    private List<CartItem> items;
    private UUID id;
    private String userEmail;

    public ShoppingCart(String email) {
        this.items = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.userEmail = email;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (CartItem item: items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
