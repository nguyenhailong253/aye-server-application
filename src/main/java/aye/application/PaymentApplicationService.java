package aye.application;

import aye.domain.payment.Payment;
import aye.domain.payment.PaymentRepository;
import aye.domain.payment.Receipt;
import aye.domain.shoppingCart.ShoppingCart;
import aye.domain.shoppingCart.ShoppingCartRepository;
import aye.infrastructure.InMemoryPaymentRepository;
import aye.infrastructure.InMemoryShoppingCartRepository;

import java.util.Map;

public class PaymentApplicationService {
    private ShoppingCartRepository shoppingCartRepository;
    private PaymentRepository paymentRepository;

    public PaymentApplicationService() {
        this.shoppingCartRepository = new InMemoryShoppingCartRepository();
        this.paymentRepository = new InMemoryPaymentRepository();
    }

    public Receipt processPayment(Map<String, String> body) {
        ShoppingCart cart = shoppingCartRepository.getShoppingCartByUserEmail(body.get("email"));
        Payment payment = new Payment(body, cart);
        Receipt receipt = payment.process();
        paymentRepository.storeReceipt(receipt);
        shoppingCartRepository.deleteShoppingCart(body.get("email"));
        return receipt;
    }
}
