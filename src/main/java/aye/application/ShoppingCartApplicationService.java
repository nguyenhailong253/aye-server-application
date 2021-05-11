package aye.application;

import aye.domain.catalogue.CatalogueRepository;
import aye.domain.catalogue.Product;
import aye.domain.shoppingCart.CartItem;
import aye.domain.shoppingCart.ShoppingCart;
import aye.domain.shoppingCart.ShoppingCartRepository;
import aye.infrastructure.InMemoryCatalogueRepository;
import aye.infrastructure.InMemoryShoppingCartRepository;

public class ShoppingCartApplicationService {
    private ShoppingCartRepository shoppingCartRepository;
    private CatalogueRepository catalogueRepository;

    public ShoppingCartApplicationService() {
        this.shoppingCartRepository = new InMemoryShoppingCartRepository();
        this.catalogueRepository = new InMemoryCatalogueRepository();
    }

    public ShoppingCart getCartByEmail(String email) {
        return shoppingCartRepository.getShoppingCartByUserEmail(email);
    }

    public void createShoppingCart(String email, String productName, int quantity) {
        Product prod = catalogueRepository.getProductByName(productName);
        CartItem item = new CartItem(prod, quantity);
        ShoppingCart cart = shoppingCartRepository.getShoppingCartByUserEmail(email);
        if (cart == null) {
            cart = new ShoppingCart(email);
            cart.addItem(item);
            shoppingCartRepository.createShoppingCart(cart);
        }
    }

    public void updateShoppingCart(String email, String productName, int quantity) {
        Product prod = catalogueRepository.getProductByName(productName);
        CartItem item = new CartItem(prod, quantity);
        ShoppingCart cart = shoppingCartRepository.getShoppingCartByUserEmail(email);
        cart.addItem(item);
        shoppingCartRepository.updateShoppingCart(cart);
    }
}