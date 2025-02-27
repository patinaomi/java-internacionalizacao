package br.com.fiap.Aula001.gateways.controllers;

import br.com.fiap.Aula001.usecases.GetJwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final GetJwtToken getJwtToken;

    @PostMapping("/auth")
    public String auth(Authentication authentication) {
        return getJwtToken.execute(authentication);
    }


    @GetMapping("/auth")
    public String validate(Authentication authentication) {
        return "Olá, jwt valido" + authentication.getName();
    }
}