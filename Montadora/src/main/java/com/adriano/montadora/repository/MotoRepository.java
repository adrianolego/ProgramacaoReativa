package com.adriano.montadora.repository;

import com.adriano.montadora.document.Moto;
import com.adriano.montadora.enums.TipoVeiculo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MotoRepository extends ReactiveMongoRepository<Moto, String> {

    Flux<Moto> findAllByTipo(TipoVeiculo carro);
}
