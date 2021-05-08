package aye.presentation;

import aye.application.UserApplicationService;
import aye.domain.user.UserRepository;
import aye.infrastructure.InMemoryUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserAPI {

    private UserRepository userRepository;
    private UserApplicationService service;

    public UserAPI() {
        this.userRepository = new InMemoryUserRepository();
        this.service = new UserApplicationService(userRepository);
    }

    @GetMapping("/")
    public String test() {
        return service.getUserPassword("test.user1@hotmail.com");
    }

    @PostMapping("/")
    public boolean authenticate(@RequestBody Map<String, String> body) {
        System.out.println("request body");
        return service.authenticateUser(body.get("email"), body.get("password"));
    }
}
