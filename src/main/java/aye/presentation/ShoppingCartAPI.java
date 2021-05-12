package aye.presentation;

import aye.application.PaymentApplicationService;
import aye.application.ShoppingCartApplicationService;
import aye.domain.payment.Receipt;
import aye.domain.shoppingCart.ShoppingCart;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

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
