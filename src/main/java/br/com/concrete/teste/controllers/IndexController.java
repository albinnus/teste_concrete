package br.com.concrete.teste.controllers;

import br.com.concrete.teste.helpers.ErrorMessageApiImp;
import br.com.concrete.teste.interfaces.ErrorMessageApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ErrorMessageApi messageApi;
    @GetMapping("/")
    public ResponseEntity index(){
        return this.messageApi.messageNotFound();
    }
}
