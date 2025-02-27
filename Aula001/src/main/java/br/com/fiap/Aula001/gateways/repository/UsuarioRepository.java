package br.com.fiap.Aula001.gateways.repository;

import java.util.Optional;

import br.com.fiap.Aula001.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {


    Optional<Usuario> findByUsername(String username);
}
