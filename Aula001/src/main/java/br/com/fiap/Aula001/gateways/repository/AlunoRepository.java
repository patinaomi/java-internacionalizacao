package br.com.fiap.Aula001.gateways.repository;

import br.com.fiap.Aula001.domains.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, String> {


    Optional<Aluno> findAlunoByApelido(String apelido);

    Page<Aluno> findAlunosByMateriaPreferida(String materiaPreferida, Pageable pageable);

    List<Aluno> findAlunosByMateriaPreferidaAndApelido(String materia, String apelido);

    List<Aluno> findAlunosByDataDaMatriculaGreaterThanEqual(LocalDate date);

    List<Aluno> findAlunoByPessoaPrimeiroNomeContains(String nome);

}
