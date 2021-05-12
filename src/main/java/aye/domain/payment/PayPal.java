package aye.domain.payment;

public class PayPal implements PaymentMethod {
    private String userEmail;
    private String password;
    private int totalAmount;

    public PayPal(String userEmail, String password, int totalAmount) {
        this.userEmail = userEmail;
        this.password = password;
        this.totalAmount = totalAmount;
    }

    @Override
    public String getMethodName() {
        return "Paypal";
    }

    @Override
    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public void pay() {
        System.out.println("Handling payment....");
        System.out.println(totalAmount);
        System.out.println("Success!");
    }

    public PayPal() {}
}
