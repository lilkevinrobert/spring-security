package xyz.siopa.springsec.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.siopa.springsec.model.User;
import xyz.siopa.springsec.repository.UserRepository;
import xyz.siopa.springsec.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/",name = "api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping(path = "/users",name = "users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }


}
