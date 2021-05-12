package aye.domain.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UserTests {

    public static class TestIsEmailValid {
        @Test
        public void shouldReturnTrue_WhenEmailValid() {
            Assertions.assertTrue(User.isEmailValid("test.hello@gmail.com"));
            Assertions.assertTrue(User.isEmailValid("hello@gmail.com"));
            Assertions.assertTrue(User.isEmailValid("user@domain.co.in"));
            Assertions.assertTrue(User.isEmailValid("user@domaincom"));
            Assertions.assertFalse(User.isEmailValid("user#domain.com"));
            Assertions.assertFalse(User.isEmailValid("@yahoo.com"));
        }
    }

    public static class TestIsUserAuthorised {
        @Test
        public void shouldAssertCustomerActions() {
            User customer = new User(Role.CUSTOMER);
            Assertions.assertTrue(customer.isUserAuthorised(Actions.CHECK_OUT));
            Assertions.assertFalse(customer.isUserAuthorised(Actions.UPDATE_CATALOGUE));
            Assertions.assertFalse(customer.isUserAuthorised(Actions.GENERATE_SALES_REPORT));
        }

        @Test
        public void shouldAssertStaffActions() {
            User staff = new User(Role.STAFF);
            Assertions.assertFalse(staff.isUserAuthorised(Actions.CHECK_OUT));
            Assertions.assertTrue(staff.isUserAuthorised(Actions.UPDATE_CATALOGUE));
            Assertions.assertTrue(staff.isUserAuthorised(Actions.GENERATE_SALES_REPORT));
        }
    }
}
