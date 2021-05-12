package aye.domain.shoppingCart;

public interface ShoppingCartRepository {
    ShoppingCart getShoppingCartByUserEmail(String email);
    void createShoppingCart(ShoppingCart cart);
    void updateShoppingCart(ShoppingCart cart);
    void deleteShoppingCart(String email);
}
