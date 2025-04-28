package br.com.fiap.internacionalizacao.service;

import br.com.fiap.internacionalizacao.dto.LivroRequestDTO;
import br.com.fiap.internacionalizacao.model.Livro;
import br.com.fiap.internacionalizacao.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.repository = livroRepository;
    }

    public Livro salvarLivro(LivroRequestDTO requestDTO) {
        Livro livro = new Livro();
        BeanUtils.copyProperties(requestDTO, livro); // Copia as propriedades do DTO para o objeto Livro
        return repository.save(livro);
    }

    public Livro atualizarLivro(LivroRequestDTO requestDTO, Long id) {
        Livro livro = buscarLivro(id);
        if (livro == null) {
            return null;
        }
        BeanUtils.copyProperties(requestDTO, livro, "id"); // Copia as propriedades do DTO para o objeto Livro, exceto o ID
        return repository.save(livro);
    }

    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }

    public Livro buscarLivro(Long id) {
        Optional<Livro> livro = repository.findById(id);
        return livro.orElse(null);
    }

    public List<Livro> listarLivros() {
        return repository.findAll();
    }

}
