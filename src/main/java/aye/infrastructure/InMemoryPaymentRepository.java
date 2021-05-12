package aye.infrastructure;

import aye.domain.payment.PaymentRepository;
import aye.domain.payment.Receipt;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPaymentRepository implements PaymentRepository {
    private List<Receipt> receipts;

    public InMemoryPaymentRepository() {
        receipts = new ArrayList<>();
    }

    @Override
    public void storeReceipt(Receipt receipt) {
        receipts.add(receipt);
    }
}
