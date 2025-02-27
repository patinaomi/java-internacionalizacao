package br.com.fiap.Aula001.domains.exceptions;

public class AlunoNotFoundException extends ResourceNotFoundException {
    public AlunoNotFoundException(String message) {
        super(message);
    }
}
