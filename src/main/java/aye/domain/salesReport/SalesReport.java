package aye.domain.salesReport;

import aye.domain.payment.Receipt;
import aye.domain.shoppingCart.CartItem;

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
        int totalSale = 0;
        for (Receipt receipt: receipts) {
            for (CartItem item: receipt.getItemsPurchased()) {
                if (item.getProduct().getName().equals(reportProductName))
                    totalSale += item.getTotalPrice();
            }
        }
        return totalSale;
    }

    private int calculateTotalQuantity() {
        int totalQuantity = 0;
        for (Receipt receipt: receipts) {
            for (CartItem item: receipt.getItemsPurchased()) {
                if (item.getProduct().getName().equals(reportProductName))
                    totalQuantity += item.getQuantity();
            }
        }
        return totalQuantity;
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
