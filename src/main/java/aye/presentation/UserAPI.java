package aye.presentation;

import aye.application.UserApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserAPI {

    private UserApplicationService service;

    public UserAPI() {
        this.service = new UserApplicationService();
    }

    @PostMapping("/auth")
    public boolean authenticate(@RequestBody Map<String, String> body) {
        System.out.println("Reached users/auth");
        if (service.authenticateUser(body.get("email"), body.get("password")))
            return true;
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Unable to authenticate");
    }

    @PostMapping("")
    public void createUserAccount(@RequestBody Map<String, String> body) {
        if (!service.createAccount(body.get("email"), ("password")))
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Account already existed");
    }
}
