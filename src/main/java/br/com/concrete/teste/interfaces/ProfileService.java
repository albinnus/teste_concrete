package br.com.concrete.teste.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ProfileService {
    ResponseEntity getProfile(UUID uuid);
}
