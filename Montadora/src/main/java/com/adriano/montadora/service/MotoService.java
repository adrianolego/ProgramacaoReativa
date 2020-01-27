package com.adriano.montadora.service;

import com.adriano.montadora.document.Moto;
import com.adriano.montadora.enums.TipoVeiculo;
import com.adriano.montadora.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public Flux<Tuple2<Long, Moto>> obterMotos() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        Flux<Moto> events = motoRepository.findAllByTipo(TipoVeiculo.MOTO);
        return Flux.zip(interval, events);
    }


}
