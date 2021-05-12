package aye.domain.user;

import java.util.List;

public interface UserRepository {
    User getUserByEmail(String email);
    void addNewUser(User user);
}
