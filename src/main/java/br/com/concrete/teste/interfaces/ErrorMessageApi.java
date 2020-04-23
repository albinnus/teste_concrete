package br.com.concrete.teste.interfaces;

import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;


public interface ErrorMessageApi {
     ResponseEntity messageNotFound();
     ResponseEntity messageEmailDuplicate();
     ResponseEntity messageUnauthorized();
     ResponseEntity messageInvalidSession();
     ResponseEntity messageInvalidUserOrPassword();
}
