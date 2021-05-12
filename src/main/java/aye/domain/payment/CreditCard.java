package aye.domain.payment;

public class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String cardName;
    private String expiryDate;
    private String cvv;
    private int totalAmount;
    private String userEmail;

    public CreditCard(String cardName, String cardNumber, String expiryDate, String cvv, int totalAmount, String userEmail) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.totalAmount = totalAmount;
        this.userEmail = userEmail;
    }

    @Override
    public String getMethodName() {
        return "Credit card";
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

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
