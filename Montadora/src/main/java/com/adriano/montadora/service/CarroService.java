package com.adriano.montadora.service;

import com.adriano.montadora.document.Carro;
import com.adriano.montadora.enums.TipoVeiculo;
import com.adriano.montadora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Flux<Tuple2<Long, Carro>> obterCarros() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        Flux<Carro> events = carroRepository.findAllByTipo(TipoVeiculo.CARRO);
        return Flux.zip(interval, events);
    }
}
