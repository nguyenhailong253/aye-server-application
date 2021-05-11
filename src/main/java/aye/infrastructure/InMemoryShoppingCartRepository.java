package aye.infrastructure;

import aye.domain.shoppingCart.ShoppingCart;
import aye.domain.shoppingCart.ShoppingCartRepository;
import aye.infrastructure.utils.InMemoryShoppingCarts;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InMemoryShoppingCartRepository implements ShoppingCartRepository {
    private List<ShoppingCart> carts;

    public InMemoryShoppingCartRepository() {
//        this.carts = InMemoryShoppingCarts.generateCarts();
        this.carts = new ArrayList<>();
    }

    @Override
    public ShoppingCart getShoppingCartByUserEmail(String email) {
        return carts.stream()
                .filter(cart -> cart.getUserEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createShoppingCart(ShoppingCart cart) {
        carts.add(cart);
    }

    @Override
    public void updateShoppingCart(ShoppingCart cart) {
        int index = findExistingCartIndex(cart);
        if (index != -1) {
            carts.remove(index);
            carts.add(cart);
        }
    }

    @Override
    public void deleteShoppingCart(String email) {
        int index = findExistingCartIndex(email);
        carts.remove(index);
    }

    private int findExistingCartIndex(ShoppingCart cart) {
        int index = -1;
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUserEmail().equals(cart.getUserEmail())) {
                index = i;
            }
        }
        return index;
    }

    private int findExistingCartIndex(String email) {
        int index = -1;
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUserEmail().equals(email)) {
                index = i;
            }
        }
        return index;
    }
}
