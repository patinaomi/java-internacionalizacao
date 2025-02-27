package br.com.fiap.Aula001.gateways.mvc;

import br.com.fiap.Aula001.domains.Aluno;
import br.com.fiap.Aula001.domains.Pessoa;
import br.com.fiap.Aula001.gateways.clients.IbgeClient;
import br.com.fiap.Aula001.gateways.clients.response.EstadoResponse;
import br.com.fiap.Aula001.gateways.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/view/aluno")
@RequiredArgsConstructor
public class MVCAlunoController {

    private final AlunoRepository alunoRepository;
    private final IbgeClient ibgeClient;

    @GetMapping
    public ModelAndView getAllAlunos(
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "ASC") Sort.Direction sortingType
                                     ) {

        List<EstadoResponse> allEstados = ibgeClient.getAllEstados();
        Page<Aluno> all = alunoRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortingType, "pessoa.sobrenome").descending()));
        List<Aluno> alunos = all.getContent();
        HashMap<String, Object> models = new HashMap<>();
        models.put("alunos", alunos);
        models.put("estados", allEstados);

        System.out.println("Alunos: " + alunos.size());
        return new ModelAndView("alunos-page", models);
    }

    @GetMapping("/cadastrar")
    public ModelAndView getViewDeCadastro() {
        HashMap<String, Object> models = new HashMap<>();
//        AlunoResponse alunoResponse = AlunoResponse.builder()
//            .primeiroNome("Aluno")
//            .sobrenome("Sobrenome")
//            .registro("Registro")
//            .build();

        com.example.demo.gateways.requests.AlunoPostRequest alunoPostRequest = new com.example.demo.gateways.requests.AlunoPostRequest("Aluno Sobrenome", "documento", "registro");
        return new ModelAndView("cadastrar-aluno-page", "alunoPostRequest", alunoPostRequest);
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarAluno(com.example.demo.gateways.requests.AlunoPostRequest alunoPostRequest) {
        Aluno alunoASerSalvo = Aluno.builder()
            .registro(alunoPostRequest.registro())
            .pessoa(Pessoa.builder()
                .primeiroNome(alunoPostRequest.getPrimeiroNome())
                .sobrenome(alunoPostRequest.getSobrenome())
                .build())
            .build();
        Aluno aluno = alunoRepository.save(alunoASerSalvo);
        return new ModelAndView("redirect:/view/aluno");
    }
}