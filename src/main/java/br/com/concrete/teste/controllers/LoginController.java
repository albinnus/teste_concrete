package br.com.concrete.teste.controllers;
import br.com.concrete.teste.interfaces.LoginService;
import br.com.concrete.teste.models.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
       return this.loginService.auth(authRequest.getEmail(), authRequest.getPassword());
    }
}
