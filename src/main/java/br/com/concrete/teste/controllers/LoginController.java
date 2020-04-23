package br.com.concrete.teste.controllers;
import br.com.concrete.teste.interfaces.LoginService;
import br.com.concrete.teste.models.AuthRequest;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o objeto usuário preenchido"),
            @ApiResponse(code = 403, message = "Usuário ou senha inválidos"),
    })
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
       return this.loginService.auth(authRequest.getEmail(), authRequest.getPassword());
    }
}
