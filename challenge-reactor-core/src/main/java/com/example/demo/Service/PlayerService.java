package com.example.demo.Service;

import com.example.demo.Collection.PlayerCollection;
import com.example.demo.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Flux<List<PlayerCollection>> filtrarJugadoresMayoresA34PorUnClub() {
        return playerRepository.findAll()
                .buffer(100)
                .flatMap(player -> Flux.fromStream(player.parallelStream()).cache())
                .filter(player -> Objects.nonNull(player.getClub()))
                .filter(player -> player.getAge() >= 34 && player.club.equals("Fluminense"))
                .distinct()
                .groupBy(PlayerCollection::getClub)
                .flatMap(Flux::collectList);
    }

    public Flux<List<PlayerCollection>> filtrarJugadoresPorNacionalidadYRancking() {
        return playerRepository.findAll()
                .buffer(100)
                .flatMap(player -> Flux.fromStream(player.parallelStream()).cache())
                .sort((player, b) -> player.winners)
                .distinct()
                .groupBy(PlayerCollection::getNational)
                .flatMap(Flux::collectList);
    }

}
