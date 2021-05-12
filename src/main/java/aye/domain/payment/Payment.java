package aye.domain.payment;

import aye.domain.shoppingCart.ShoppingCart;

import java.util.Map;

public class Payment {
    private String userEmail;
    private String password;
    private String cardNumber;
    private String cardName;
    private String expiryDate;
    private String cvv;
    private PaymentMethod method;
    private ShoppingCart cart;
    private int totalAmount;

    public Payment(Map<String, String> body, ShoppingCart cart) {
        this.cart = cart;
        this.userEmail = body.get("email");
        this.password = body.get("password");
        this.cardNumber = body.get("cardNumber");
        this.cardName = body.get("cardName");
        this.expiryDate = body.get("expiryDate");
        this.cvv = body.get("cvv");
        this.totalAmount = cart.getTotalPrice();
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
