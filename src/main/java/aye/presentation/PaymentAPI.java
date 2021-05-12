package aye.presentation;

import aye.application.PaymentApplicationService;
import aye.domain.payment.Receipt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentAPI {
    private PaymentApplicationService service;

    public PaymentAPI() {
        service = new PaymentApplicationService();
    }

    @PostMapping("")
    public Receipt checkOut(@RequestBody Map<String, String> body) {
        return service.processPayment(body);
    }
}
