package br.com.fiap.Aula001.usecases;

import br.com.fiap.Aula001.domains.Aluno;
import org.springframework.stereotype.Service;

@Service
public interface CadastrarAluno {

    Aluno executa(Aluno alunoParaSerCadastrar);
}
