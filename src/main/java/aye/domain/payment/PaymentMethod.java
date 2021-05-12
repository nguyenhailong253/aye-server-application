package aye.domain.payment;

public interface PaymentMethod {
    String getMethodName();
    String getUserEmail();
    void pay();
}
