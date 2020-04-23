package br.com.concrete.teste.services;

import br.com.concrete.teste.interfaces.ErrorMessageApi;
import br.com.concrete.teste.interfaces.ProfileService;
import br.com.concrete.teste.interfaces.UserService;
import br.com.concrete.teste.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileServiceImp implements ProfileService {
    @Autowired
    private ErrorMessageApi errorMessageApi;

    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity getProfile(UUID uuid) {
        User user = this.userService.getUser(uuid);

        if(user==null){
            return this.errorMessageApi.messageNotFound();
        }

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
