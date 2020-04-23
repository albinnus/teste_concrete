package br.com.concrete.teste.controllers;

import br.com.concrete.teste.interfaces.UserService;
import br.com.concrete.teste.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postRegisterUser(@RequestBody User user){
       return userService.create(user);
    }
}
