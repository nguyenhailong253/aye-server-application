package aye.presentation;

import aye.application.ShoppingCartApplicationService;
import aye.application.UserApplicationService;
import aye.domain.shoppingCart.ShoppingCart;
import aye.domain.user.Actions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class ShoppingCartAPI {

    private ShoppingCartApplicationService service;
    private UserApplicationService userService;

    public ShoppingCartAPI() {
        service = new ShoppingCartApplicationService();
        userService = new UserApplicationService();
    }

    @GetMapping("")
    public ShoppingCart getCart(@RequestParam String email) {
        if (userService.isUserAuthorised(email, Actions.CHECK_OUT)) {
            ShoppingCart cart = service.getCartByEmail(email);
            if (cart != null) return cart;
            else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No cart existed");
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorised for this action");
    }

    @PostMapping("")
    public void createNewCart(@RequestBody Map<String, String> body) {
        if (userService.isUserAuthorised(body.get("email"), Actions.CHECK_OUT)) {
            service.createShoppingCart(body.get("email"),
                    body.get("productName"),
                    Integer.parseInt(body.get("quantity")));
        } else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorised for this action");
    }

    @PutMapping("")
    public void updateCart(@RequestBody Map<String, String> body) {
        if (userService.isUserAuthorised(body.get("email"), Actions.CHECK_OUT)) {
            service.updateShoppingCart(body.get("email"),
                    body.get("productName"),
                    Integer.parseInt(body.get("quantity")));
        } else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorised for this action");
    }
}
