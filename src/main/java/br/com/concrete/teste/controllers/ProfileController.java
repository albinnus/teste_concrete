package br.com.concrete.teste.controllers;
import br.com.concrete.teste.interfaces.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    @GetMapping(value = "/{uuid}")
    public ResponseEntity<?> getUser(@PathVariable UUID uuid){
        return this.profileService.getProfile(uuid);
    }
}
