package br.com.fiap.Aula001.gateways.clients;

import br.com.fiap.Aula001.gateways.clients.response.EstadoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ibge", url = "https://servicodados.ibge.gov.br")
public interface IbgeClient {

    @GetMapping("/api/v1/localidades/estados")
    List<EstadoResponse> getAllEstados();
}
