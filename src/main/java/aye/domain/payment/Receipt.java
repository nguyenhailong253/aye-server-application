package aye.domain.payment;

import aye.domain.shoppingCart.CartItem;
import aye.domain.shoppingCart.ShoppingCart;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Receipt {
    private List<CartItem> itemsPurchased;
    private int totalPrice;
    private int amountPaid;
    private String paymentMethod;
    private String userEmail;
    private String transactionDate;

    public Receipt(ShoppingCart cart, PaymentMethod paymentMethod) {
        this.itemsPurchased = cart.getItems();
        this.totalPrice = cart.getTotalPrice();
        this.amountPaid = cart.getTotalPrice();
        this.paymentMethod = paymentMethod.getMethodName();
        this.userEmail = paymentMethod.getUserEmail();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.transactionDate = dtf.format(now);
    }

    public Receipt() {}

    public String getUserEmail() {
        return userEmail;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<CartItem> getItemsPurchased() {
        return itemsPurchased;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getTransactionDate() {
        return transactionDate;
    }
}
