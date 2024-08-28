package br.com.fiap.aula001.repository;


import br.com.fiap.aula001.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}