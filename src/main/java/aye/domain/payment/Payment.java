package aye.domain.payment;

import aye.domain.shoppingCart.ShoppingCart;

import java.util.Map;

public class Payment {
    private PaymentMethod method;
    private ShoppingCart cart;

    public Payment(Map<String, String> body, ShoppingCart cart) {
        this.cart = cart;
        String userEmail = body.get("email");
        String password = body.get("password");
        String cardNumber = body.get("cardNumber");
        String cardName = body.get("cardName");
        String expiryDate = body.get("expiryDate");
        String cvv = body.get("cvv");
        int totalAmount = cart.getTotalPrice();
        if (body.get("method").equals("paypal"))
            method = new PayPal(userEmail, password, totalAmount);
        else
            method = new CreditCard(cardName, cardNumber, expiryDate, cvv, totalAmount, userEmail);
    }

    public Receipt process() {
        method.pay();
        return new Receipt(cart, method);
    }
}
