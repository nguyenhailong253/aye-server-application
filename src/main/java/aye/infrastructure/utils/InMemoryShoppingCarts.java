package aye.infrastructure.utils;

import aye.domain.catalogue.Product;
import aye.domain.shoppingCart.CartItem;
import aye.domain.shoppingCart.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShoppingCarts {
    public static List<ShoppingCart> generateCarts() {
        ShoppingCart cart = new ShoppingCart("test.user1@hotmail.com");

        Product laptop = new Product("macbook");
        laptop.setPrice(10000);

        cart.addItem(new CartItem(laptop, 1));

        List<ShoppingCart> carts = new ArrayList<>();
        carts.add(cart);
        return carts;
    }
}
