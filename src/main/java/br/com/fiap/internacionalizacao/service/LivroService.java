package br.com.fiap.internacionalizacao.service;

import br.com.fiap.internacionalizacao.dto.LivroRequestDTO;
import br.com.fiap.internacionalizacao.model.Livro;
import br.com.fiap.internacionalizacao.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvarLivro(LivroRequestDTO dto) {

    }

}
