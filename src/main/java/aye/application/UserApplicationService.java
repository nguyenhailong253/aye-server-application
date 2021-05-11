package aye.application;

import aye.domain.user.Role;
import aye.domain.user.User;
import aye.domain.user.UserRepository;
import aye.infrastructure.InMemoryUserRepository;
import aye.utils.Actions;

public class UserApplicationService {

    private UserRepository userRepository;

    public UserApplicationService() {
        this.userRepository = new InMemoryUserRepository();
    }

    public boolean authenticateUser(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if (user != null) {
            return user.verifyPassword(password);
        }
        return false;
    }

    public boolean isUserExisted(String email) {
        User user = userRepository.getUserByEmail(email);
        if (user != null) return true;
        return false;
    }

    public void createAccount(String email, String password) {
        User user = new User(Role.CUSTOMER);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.addNewUser(user);
    }

    public boolean isUserAuthorised(String email, Actions action) {
        User user = userRepository.getUserByEmail(email);
        return user.isUserAuthorised(action);
    }
}
