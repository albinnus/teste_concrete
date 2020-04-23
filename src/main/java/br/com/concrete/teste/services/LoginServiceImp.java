package br.com.concrete.teste.services;

import br.com.concrete.teste.helpers.JwtToken;
import br.com.concrete.teste.interfaces.ErrorMessageApi;
import br.com.concrete.teste.interfaces.LoginService;
import br.com.concrete.teste.interfaces.UserService;
import br.com.concrete.teste.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private ErrorMessageApi errorMessageApi;

    @Autowired
    private JwtToken jwtToken;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity auth(String email, String password) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            User userLogin = login(email);
            return new ResponseEntity<>(userLogin, HttpStatus.OK);
        }catch (DisabledException | BadCredentialsException | UsernameNotFoundException | AuthenticationCredentialsNotFoundException e){
            return this.errorMessageApi.messageInvalidUserOrPassword();
        }
    }


    private User login(String email) {
        User user = this.userService.getUserByEmail(email);
        user.setToken(jwtToken.generateToken(email));
        user.setLast_login(LocalDateTime.now());
        this.userService.updateUser(user);
        return  user;
    }





}
