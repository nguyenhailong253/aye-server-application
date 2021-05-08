package aye.application;

import aye.domain.user.UserRepository;
import aye.infrastructure.InMemoryUserRepository;
import aye.utils.Actions;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserApplicationServiceTests {

    private static UserRepository userRepository = new InMemoryUserRepository();
    private static UserApplicationService service = new UserApplicationService(userRepository);

    public static class TestAuthenticateUser {
        @Test
        public void shouldReturnTrue_WhenEmailAndPasswordExist() {
            String email = "test.user1@hotmail.com";
            String password = "123456";
            Assertions.assertTrue(service.authenticateUser(email, password));
        }

        @Test
        public void shouldReturnFalse_WhenEmailAndPasswordNotExist() {
            String email = "no_exist@gmail.com";
            String password = "123456";
            Assertions.assertFalse(service.authenticateUser(email, password));
        }
    }

    public static class TestIsUserAuthorised {
        @Test
        public void shouldReturnTrue_WhenUserIsAuthorisedToDoAction() {
            String email = "test.user1@hotmail.com";
            Assertions.assertTrue(service.isUserAuthorised(email, Actions.CHECK_OUT));
        }

        @Test
        public void shouldReturnFalse_WhenUserIsNotAuthorised() {
            String email = "test.user1@hotmail.com";
            Assertions.assertFalse(service.isUserAuthorised(email, Actions.GENERATE_SALES_REPORT));
        }
    }
}
