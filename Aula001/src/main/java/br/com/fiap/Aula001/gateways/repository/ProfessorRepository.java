package br.com.fiap.Aula001.gateways.repository;


import br.com.fiap.Aula001.domains.Professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
}
