package br.com.fiap.internacionalizacao.controller;

import br.com.fiap.internacionalizacao.dto.LivroRequestDTO;
import br.com.fiap.internacionalizacao.model.Livro;
import br.com.fiap.internacionalizacao.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    @Autowired
    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livroCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(@Valid LivroRequestDTO livroRequestDTO, BindingResult bindingResult, Model model) {
        //Binding Result verifica se o objeto está válido
        if (bindingResult.hasErrors()) {
            return "livroCadastro";
        }
        // Se não houver erros, salva o livro
        service.salvarLivro(livroRequestDTO);
        return listarLivros(model);
    }

    @GetMapping("/lista")
    public String listarLivros(Model model) {
        List<Livro> livros = service.listarLivros();
        model.addAttribute("listaLivros", livros);
        return "livroLista";
    }

    @GetMapping("/edicao/{id}")
    public String livroEdicao(@PathVariable Long id, Model model) {
        Livro livro = service.buscarLivro(id);
        if (livro == null) {
            return listarLivros(model);
        }
        model.addAttribute("id", id);
        model.addAttribute("livro", livro);
        return "livroEdicao";
    }

    @GetMapping("/editar/{id}")
    public String editarLivro(@PathVariable Long id, @Valid LivroRequestDTO livroRequestDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "livroEdicao";
        }
        service.atualizarLivro(livroRequestDTO, id);
        return listarLivros(model);
    }

    @GetMapping("excluir/{id}")
    public String excluirLivro(@PathVariable Long id, Model model) {
        service.deletarLivro(id);
        return listarLivros(model);
    }
}
