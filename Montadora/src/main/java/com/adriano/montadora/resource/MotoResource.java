package com.adriano.montadora.resource;

import com.adriano.montadora.document.Moto;
import com.adriano.montadora.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@RestController
public class MotoResource {

    @Autowired
    private MotoService motoService;

    @GetMapping(value = "/listarMotos", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Moto>> getMotos() {
        return motoService.obterMotos();
    }
}
