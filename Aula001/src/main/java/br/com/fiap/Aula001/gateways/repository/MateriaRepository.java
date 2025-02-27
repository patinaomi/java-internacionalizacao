package br.com.fiap.Aula001.gateways.repository;

import br.com.fiap.Aula001.domains.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, String> {
}
