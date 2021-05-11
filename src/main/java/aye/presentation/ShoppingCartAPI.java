package aye.presentation;

import aye.application.ShoppingCartApplicationService;
import aye.domain.shoppingCart.ShoppingCart;
import aye.domain.shoppingCart.ShoppingCartRepository;
import aye.infrastructure.InMemoryShoppingCartRepository;
import aye.utils.SimplifiedCart;
import aye.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/cart")
public class ShoppingCartAPI {

    private ShoppingCartApplicationService service;

    public ShoppingCartAPI() {
        service = new ShoppingCartApplicationService();
    }

    @GetMapping("")
    public ShoppingCart getCart(@RequestParam String email) {
        ShoppingCart cart = service.getCartByEmail(email);
        if (cart != null) return cart;
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No cart existed");
    }

    @PostMapping("")
    public void createNewCart(@RequestBody Map<String, String> body) {
        service.createShoppingCart(body.get("email"),
                body.get("productName"),
                Integer.parseInt(body.get("quantity")));
    }

    @PutMapping("")
    public void updateCart(@RequestBody Map<String, String> body) {
        service.updateShoppingCart(body.get("email"),
                body.get("productName"),
                Integer.parseInt(body.get("quantity")));
    }
}
