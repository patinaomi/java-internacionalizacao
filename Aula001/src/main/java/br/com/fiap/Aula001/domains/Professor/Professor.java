package br.com.fiap.Aula001.domains.Professor;

import br.com.fiap.Aula001.domains.Aluno;
import br.com.fiap.Aula001.domains.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Professor {

    @Id
    private ProfessorId professorId;


    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @OneToMany(mappedBy = "professor")
    private List<Aluno> alunos;

}