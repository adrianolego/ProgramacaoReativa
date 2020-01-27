package com.adriano.montadora.util;

import com.adriano.montadora.document.Carro;
import com.adriano.montadora.document.Moto;
import com.adriano.montadora.enums.TipoVeiculo;
import com.adriano.montadora.repository.CarroRepository;
import com.adriano.montadora.repository.MotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class Dados implements CommandLineRunner {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private MotoRepository motoRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Carro> listaCarros = new ArrayList<>();
        listaCarros.add(new Carro(null, TipoVeiculo.CARRO, 5, "Toyota", 5, 370L));
        listaCarros.add(new Carro(null, TipoVeiculo.CARRO, 5, "Honda", 5, 360L));
        listaCarros.add(new Carro(null, TipoVeiculo.CARRO, 5, "Nissan", 5, 340L));
        listaCarros.add(new Carro(null, TipoVeiculo.CARRO, 5, "Chevrolet", 5, 350L));

        List<Moto> listaMotos = new ArrayList<>();
        listaMotos.add(new Moto(null, TipoVeiculo.MOTO, 2, "Yamaha", 250L, 2));
        listaMotos.add(new Moto(null, TipoVeiculo.MOTO, 2, "Honda", 150L, 2));
        listaMotos.add(new Moto(null, TipoVeiculo.MOTO, 2, "Suzuki", 250L, 2));
        listaMotos.add(new Moto(null, TipoVeiculo.MOTO, 3, "Harley-Davidson", 550L, 3));
        listaMotos.add(new Moto(null, TipoVeiculo.MOTO, 2, "Bmw", 750L, 2));

        var carros = Flux.just(listaCarros)
                .flatMap(carroRepository::saveAll);

        var motos = Flux.just(listaMotos)
                .flatMap(motoRepository::saveAll);

        carroRepository.deleteAll()
                .thenMany(carros)
                .thenMany(carroRepository.findAll())
                .subscribe(log::info);

        motoRepository.deleteAll()
                .thenMany(motos)
                .thenMany(motoRepository.findAll())
                .subscribe(log::info);
    }
}
