package aye.domain.user;

public interface UserRepository {
    User getUserByEmail(String email);
    void addNewUser(User user);
}
