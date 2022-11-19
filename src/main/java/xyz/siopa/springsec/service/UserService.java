package xyz.siopa.springsec.service;

import xyz.siopa.springsec.model.Role;
import xyz.siopa.springsec.model.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    User getUser(String username);
    List<User> getUsers();
}
