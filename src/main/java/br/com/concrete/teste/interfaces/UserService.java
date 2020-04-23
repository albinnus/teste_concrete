package br.com.concrete.teste.interfaces;

import br.com.concrete.teste.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {

    ResponseEntity create(User user);


    User updateUser(User user);

    User getUser(UUID id);

    User getUserByEmail(String email);


}