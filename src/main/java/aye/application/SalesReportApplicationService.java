package aye.application;

import aye.domain.payment.PaymentRepository;
import aye.domain.payment.Receipt;
import aye.domain.salesReport.SalesReport;
import aye.infrastructure.InMemoryPaymentRepository;

import java.util.List;

public class SalesReportApplicationService {
    private PaymentRepository paymentRepository;

    public SalesReportApplicationService() {
        this.paymentRepository = new InMemoryPaymentRepository();
    }

    public SalesReport generateSalesReportForAProduct(String productName, String period) {
        List<Receipt> receipts = paymentRepository.getReceiptsContainProductName(productName, period);
        return new SalesReport(receipts, productName, period);
    }
}
