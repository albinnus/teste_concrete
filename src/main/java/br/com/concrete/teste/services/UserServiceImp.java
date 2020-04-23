package br.com.concrete.teste.services;

import br.com.concrete.teste.helpers.JwtToken;
import br.com.concrete.teste.interfaces.ErrorMessageApi;
import br.com.concrete.teste.interfaces.UserService;
import br.com.concrete.teste.models.User;
import br.com.concrete.teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private ErrorMessageApi errorMessageApi;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder;


    public UserServiceImp(){
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public ResponseEntity create(User user) {
        if (checkEmail(user.getEmail())) {
            return this.errorMessageApi.messageEmailDuplicate();
        }

        user.setPassword(this.encoder.encode(user.getPassword()));
        user.setLast_login(LocalDateTime.now());
        return new ResponseEntity(userRepository.save(user), HttpStatus.CREATED);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    private Boolean checkEmail(String email) {
        return this.userRepository.countByEmail(email) > 0;
    }


    @Override
    public User getUser(UUID id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }


}