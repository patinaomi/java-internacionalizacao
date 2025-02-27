package br.com.fiap.Aula001.gateways.dtos.responses;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
public class MateriaResponse extends RepresentationModel<MateriaResponse> {

    private String descricao;

}
