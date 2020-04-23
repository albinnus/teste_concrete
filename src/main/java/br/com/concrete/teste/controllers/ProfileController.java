package br.com.concrete.teste.controllers;
import br.com.concrete.teste.interfaces.ProfileService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o objeto usuário preenchido"),
            @ApiResponse(code = 401, message = "Não Autorizado"),
    })
    @GetMapping(value = "/{uuid}")
    public ResponseEntity<?> getUser(@PathVariable UUID uuid){
        return this.profileService.getProfile(uuid);
    }
}
