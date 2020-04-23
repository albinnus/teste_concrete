package br.com.concrete.teste.helpers;

import br.com.concrete.teste.interfaces.ErrorMessageApi;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class ErrorMessageApiImp implements ErrorMessageApi {

    private Map<String, Object> responseBody = new LinkedHashMap<>();

    @ResponseBody
    public ResponseEntity messageNotFound() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",Constante.NOT_FOUND);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.ACCEPTED.NOT_FOUND);
    }


    @ResponseBody
    public ResponseEntity messageEmailDuplicate() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",Constante.EXISTING_EMAIL);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public ResponseEntity messageUnauthorized() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",Constante.UNAUTHORIZED);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public ResponseEntity messageInvalidSession() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",Constante.INVALID_SESSION);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public ResponseEntity messageInvalidUserOrPassword() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        responseBody.put("mensagem",Constante.INVALID_USER_OR_PASSWORD);
        return new ResponseEntity<>(responseBody, headers, HttpStatus.UNAUTHORIZED);
    }


}
