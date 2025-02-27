package br.com.fiap.Aula001.gateways.controllers;

import br.com.fiap.Aula001.domains.Usuario;
import br.com.fiap.Aula001.gateways.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUser(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario.withSenha(passwordEncoder.encode(usuario.getSenha())));
    }
}