package br.com.fiap.Aula001;

import br.com.fiap.Aula001.domains.Aluno;
import br.com.fiap.Aula001.domains.AuditableData;
import br.com.fiap.Aula001.domains.Materia;
import br.com.fiap.Aula001.domains.Pessoa;
import br.com.fiap.Aula001.gateways.clients.IbgeLocalidadesClient;
import br.com.fiap.Aula001.gateways.clients.response.EstadoResponse;
import br.com.fiap.Aula001.gateways.clients.response.MunicipioResponse;
import br.com.fiap.Aula001.gateways.repository.AlunoRepository;
import br.com.fiap.Aula001.gateways.repository.MateriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
public class ProjetoMVCApplication {

    private final AlunoRepository alunoRepository;
    private final MateriaRepository materiaRepository;
    private final IbgeLocalidadesClient ibgeLocalidadesClient;

    public static void main(String[] args) {
        SpringApplication.run(ProjetoMVCApplication.class, args);


    }


    @EventListener(value = ApplicationReadyEvent.class)
    public void setupAlunos() {
        List<EstadoResponse> allEstados = ibgeLocalidadesClient.getAllEstados();
        List<MunicipioResponse> municipioPorEstado = ibgeLocalidadesClient.getAllMunicipiosPorEstado("11");
        LocalDate now = LocalDate.now();
        List<Materia> materias = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Materia build = Materia.builder()
                    .nome("Materia " + i)
                    .build();
            Materia saved = materiaRepository.save(build);
            materias.add(saved);
        }
        for (int i = 0; i <= 200; i++) {
            if (i % 10 == 0) {
                now = now.plusDays(1);
            }
            Aluno alunoASerCadastrado = Aluno.builder()
                    .pessoa(Pessoa.builder()
                            .primeiroNome("Aluno ")
                            .sobrenome("" + i)
                            .build())
                    .dataDaMatricula(now)
                    .apelido("" + i)
                    .materiaPreferida("JavaAdvanced")
                    .materias(materias)
                    .auditableData(new AuditableData())
                    .build();
            alunoRepository.save(alunoASerCadastrado);
        }
    }
}