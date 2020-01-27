package com.adriano.montadora.resource;

import com.adriano.montadora.model.Veiculo;
import com.adriano.montadora.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@RestController
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping(value = "/listarVeiculos", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Veiculo>> getVeiculos() {
        return veiculoService.obterTodosVeiculos();
    }
}
