package com.adriano.montadora.service;

import com.adriano.montadora.enums.TipoVeiculo;
import com.adriano.montadora.model.Veiculo;
import com.adriano.montadora.repository.CarroRepository;
import com.adriano.montadora.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;

@Service
public class VeiculoService {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private MotoRepository motoRepository;

    public Flux<Tuple2<Long, Veiculo>> obterTodosVeiculos() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        Flux<Veiculo> veiculos =
                Flux.merge(carroRepository.findAllByTipo(TipoVeiculo.CARRO)
                        , motoRepository.findAllByTipo(TipoVeiculo.MOTO));
        return Flux.zip(interval, veiculos);
    }
}
