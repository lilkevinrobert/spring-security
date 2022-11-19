package xyz.siopa.springsec.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;
import xyz.siopa.springsec.model.Role;
import xyz.siopa.springsec.model.User;
import xyz.siopa.springsec.repository.RoleRepository;
import xyz.siopa.springsec.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("saving user to database");
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role to database");
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        log.info("adding Role To User user to database");
        User user = userRepository.findUserByUsername(username);
        Role roles = roleRepository.findByName(role);
        user.getRoles().add(roles);
    }

    @Override
    public User getUser(String username) {
        log.info("getUser user from database");
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Returning user from database");
        return userRepository.findAll();
    }
}
