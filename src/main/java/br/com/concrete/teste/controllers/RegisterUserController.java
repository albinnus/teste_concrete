package br.com.concrete.teste.controllers;

import br.com.concrete.teste.interfaces.UserService;
import br.com.concrete.teste.models.User;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o objeto usuário preenchido"),
            @ApiResponse(code = 401, message = "Email já cadastrado"),
    })
    @PostMapping(value="/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postRegisterUser(@RequestBody User user){
       return userService.create(user);
    }
}
