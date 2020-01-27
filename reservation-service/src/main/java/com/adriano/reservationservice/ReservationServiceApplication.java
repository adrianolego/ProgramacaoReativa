package com.adriano.reservationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }
}

@Component
@Log4j2
@RequiredArgsConstructor
class SampleDataInicializer implements CommandLineRunner {

    private final ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception{

        var just = Flux.just("Lego", "Minion", "Nerso", "Rosa")
                .map(name -> new Reservation(null, name))
                .flatMap(this.reservationRepository::save);

        this.reservationRepository
                .deleteAll()
                .thenMany(just)
                .thenMany(this.reservationRepository.findAll())
                .subscribe(log::info);
    }
}

@Repository
interface ReservationRepository extends ReactiveMongoRepository<Reservation, String> {
}

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Reservation {
    @Id
    private String id;
    private String name;
}

