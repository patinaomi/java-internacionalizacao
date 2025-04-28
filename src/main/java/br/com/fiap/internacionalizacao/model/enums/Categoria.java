package br.com.fiap.internacionalizacao.model.enums;

public enum Categoria {
    FICCAO("Ficção"),
    NAO_FICCAO("Não Ficção"),
    INFANTIL("Infantil"),
    AVENTURA("Aventura"),
    FANTASIA("Fantasia"),
    ROMANCE("Romance"),
    HISTORIA("História"),
    BIOGRAFIA("Biografia");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
