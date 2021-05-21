package aye.presentation;

import aye.application.SalesReportApplicationService;
import aye.application.UserApplicationService;
import aye.domain.salesReport.SalesReport;
import aye.domain.user.Actions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class SalesReportAPI {
    private SalesReportApplicationService service;
    private UserApplicationService userService;

    public SalesReportAPI() {
        service = new SalesReportApplicationService();
        userService = new UserApplicationService();
    }

    @GetMapping("")
    public SalesReport getSalesReport(@RequestParam String email, @RequestParam String productName, @RequestParam String period) {
        if (userService.isUserAuthorised(email, Actions.GENERATE_SALES_REPORT))
            return service.generateSalesReportForAProduct(productName, period);
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authorised for this action");
    }
}
