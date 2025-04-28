package br.com.fiap.internacionalizacao.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record LivroRequestDTO(
        @NotBlank(message = "O título não pode ser vazio")
        String titulo,
        @NotBlank(message = "O autor não pode ser vazio")
        @Size(min = 4, max = 50, message = "O autor deve ter entre 4 e 50 caracteres")
        String autor,
        @NotNull(message = "A categoria não pode ser nula")
        String categoria,
        @DecimalMin(value = "0.99", message = "O preço deve ser no mínimo 0.99")
        BigDecimal preco,
        @Pattern(regexp = "ˆ970\\d{7}$|ˆ970\\d{10}$", message = "O ISBN deve começar com 970 e ter 10 ou 13 dígitos")
        String isbn
) {
}
