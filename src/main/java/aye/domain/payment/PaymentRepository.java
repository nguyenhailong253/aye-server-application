package aye.domain.payment;

import java.util.List;

public interface PaymentRepository {
    void storeReceipt(Receipt receipt);
    List<Receipt> getReceiptsContainProductName(String productName);
}
