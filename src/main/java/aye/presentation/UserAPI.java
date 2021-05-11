package aye.presentation;

import aye.application.UserApplicationService;
import aye.domain.user.UserRepository;
import aye.infrastructure.InMemoryUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserAPI {

    private UserApplicationService service;

    public UserAPI() {
        this.service = new UserApplicationService();
    }

    @PostMapping("")
    public boolean authenticate(@RequestBody Map<String, String> body) {
        if (service.authenticateUser(body.get("email"), body.get("password")))
            return true;
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Unable to authenticate");
    }

    @PostMapping("/create")
    public void createUserAccount(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        if (!service.isUserExisted(email)) {
            service.createAccount(email, password);
            return;
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Account already existed");
    }
}
