package br.com.fiap.Aula001.gateways.clients;

import br.com.fiap.Aula001.gateways.clients.response.EstadoResponse;
import br.com.fiap.Aula001.gateways.clients.response.MunicipioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ibgeFeign2", url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados")
public interface IbgeLocalidadesClient {

    @GetMapping
    List<EstadoResponse> getAllEstados();


    @GetMapping("/{uf}/municipios")
    List<MunicipioResponse> getAllMunicipiosPorEstado(@PathVariable String uf);
}