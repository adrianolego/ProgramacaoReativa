package com.adriano.montadora.resource;

import com.adriano.montadora.document.Carro;
import com.adriano.montadora.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@RestController
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @GetMapping(value = "/listarCarros", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Carro>> getCarros() {
        return carroService.obterCarros();
    }
}
