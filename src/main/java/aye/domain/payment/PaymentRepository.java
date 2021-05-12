package aye.domain.payment;

public interface PaymentRepository {
    void storeReceipt(Receipt receipt);
}
