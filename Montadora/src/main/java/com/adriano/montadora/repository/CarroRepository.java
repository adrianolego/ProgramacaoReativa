package com.adriano.montadora.repository;

import com.adriano.montadora.document.Carro;
import com.adriano.montadora.enums.TipoVeiculo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CarroRepository extends ReactiveMongoRepository<Carro, String> {

    Flux<Carro> findAllByTipo(TipoVeiculo carro);
}
