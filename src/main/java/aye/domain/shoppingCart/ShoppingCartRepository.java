package aye.domain.shoppingCart;

import java.util.UUID;

public interface ShoppingCartRepository {
    ShoppingCart getShoppingCartByUserEmail(String email);
    void createShoppingCart(ShoppingCart cart);
    void updateShoppingCart(ShoppingCart cart);
    void deleteShoppingCart(String email);
}
