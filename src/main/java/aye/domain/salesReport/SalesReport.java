package aye.domain.salesReport;

import aye.domain.payment.Receipt;

import java.util.List;

public class SalesReport {

    private List<Receipt> receipts;
    private String reportProductName;
    private String period;
    private int totalSales;
    private int totalQuantity;

    public SalesReport() {}

    public SalesReport(List<Receipt> receipts, String reportProductName, String period) {
        this.receipts = receipts;
        this.reportProductName = reportProductName;
        this.period = period;
        this.totalQuantity = calculateTotalQuantity();
        this.totalSales = calculateTotalSales();
    }

    private int calculateTotalSales() {
        return 0;
    }

    private int calculateTotalQuantity() {
        return 0;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public String getPeriod() {
        return period;
    }

    public String getReportProductName() {
        return reportProductName;
    }
}
