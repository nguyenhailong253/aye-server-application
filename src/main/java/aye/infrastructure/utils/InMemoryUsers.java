package aye.infrastructure.utils;

import aye.domain.user.Role;
import aye.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUsers {
    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>();

        User user1 = new User(Role.CUSTOMER);
        user1.setEmail("test.user1@hotmail.com");
        user1.setPassword("123456");

        User user2 = new User(Role.CUSTOMER);
        user2.setEmail("test.user2@hotmail.com");
        user2.setPassword("123456");

        User user3 = new User(Role.CUSTOMER);
        user3.setEmail("test.user3@hotmail.com");
        user3.setPassword("123456");

        User admin = new User(Role.STAFF);
        admin.setEmail("test.admin@hotmail.com");
        admin.setPassword("123456");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(admin);

        return users;
    }
}
