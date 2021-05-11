package aye.domain.user;

import aye.utils.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private Role role;
    private String email;
    private String password;
    private UUID id;
    private List<Actions> staffActions;
    private List<Actions> customerActions;

    public User(Role role) {
        this.role = role;
        id = UUID.randomUUID();
        staffActions = getStaffActions();
        customerActions = getCustomerActions();
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean isEmailValid(String email) {
        String regex = "^(.+)@(.+)$";
        Matcher pattern = Pattern.compile(regex).matcher(email);
        return pattern.matches();
    }

    public boolean isUserAuthorised(Actions action) {
        if (role.equals(Role.CUSTOMER))
            return customerActions.contains(action);
        else
            return staffActions.contains(action);
    }

    public boolean verifyPassword(String password) {
        return getPassword().equals(password);
    }

    private List<Actions> getStaffActions() {
        List<Actions> actions = new ArrayList<>();
        actions.add(Actions.UPDATE_CATALOGUE);
        actions.add(Actions.GENERATE_SALES_REPORT);
        return actions;
    }

    private List<Actions> getCustomerActions() {
        List<Actions> actions = new ArrayList<>();
        actions.add(Actions.CHECK_OUT);
        return actions;
    }
}

