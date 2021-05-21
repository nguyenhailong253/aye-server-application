package aye.presentation;

import aye.application.PaymentApplicationService;
import aye.application.UserApplicationService;
import aye.domain.payment.Receipt;
import aye.domain.user.Actions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentAPI {
    private PaymentApplicationService service;
    private UserApplicationService userService;

    public PaymentAPI() {
        service = new PaymentApplicationService();
        userService = new UserApplicationService();
    }

    @PostMapping("")
    public Receipt checkOut(@RequestBody Map<String, String> body) {
        if (userService.isUserAuthorised(body.get("email"), Actions.CHECK_OUT))
            return service.processPayment(body);
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorised for this action");
    }
}
