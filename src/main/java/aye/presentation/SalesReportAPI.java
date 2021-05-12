package aye.presentation;

import aye.application.SalesReportApplicationService;
import aye.domain.salesReport.SalesReport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class SalesReportAPI {
    private SalesReportApplicationService service;

    public SalesReportAPI() {
        service = new SalesReportApplicationService();
    }

    @GetMapping("")
    public SalesReport getSalesReport(@RequestParam String productName, @RequestParam String period) {
        return service.generateSalesReportForAProduct(productName, period);
    }
}
