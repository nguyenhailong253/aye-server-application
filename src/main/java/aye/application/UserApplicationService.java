package aye.application;

import aye.domain.user.User;
import aye.domain.user.UserRepository;
import aye.utils.Actions;

public class UserApplicationService {

    private UserRepository userRepository;

    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }

    public boolean isUserAuthorised(String email, Actions action) {
        User user = userRepository.getUserByEmail(email);
        return user.isUserAuthorised(action);
    }

    public String getUserPassword(String email) {
        User user = userRepository.getUserByEmail(email);
        return user.getPassword();
    }
}
