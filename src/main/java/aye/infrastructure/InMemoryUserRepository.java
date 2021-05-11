package aye.infrastructure;

import aye.domain.user.User;
import aye.domain.user.UserRepository;
import aye.infrastructure.utils.InMemoryUsers;

import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private List<User> users;

    public InMemoryUserRepository() {
        users = InMemoryUsers.generateUsers();
    }

    @Override
    public User getUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public void addNewUser(User user) {
        users.add(user);
    }
}
