package com.example.demo.Util;

import com.example.demo.Model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

public class CSVUtilTest {

    List<Player> list = CsvUtilFile.getPlayers();

    @Test
    void converterData(){
        assert list.size() == 18207;
    }

    @Test
    void filtrarJugadoresMayoresA34PorUnClub(){
        Flux<Player> listFlux = Flux.fromStream(list.parallelStream()).cache();
        Mono<Map<String, Collection<Player>>> listFilter = listFlux
                .filter(player -> player.age >= 34 && player.club.equals("Fluminense"))
                .map(player -> {
                    player.name = player.name.toUpperCase(Locale.ROOT);
                    return player;
                })
                .buffer(100)
                .flatMap(playerA -> listFlux
                        .filter(playerB -> playerA.stream()
                                .anyMatch(a ->  a.club.equals(playerB.club) && a.age == playerB.age))
                )
                .distinct()
                .collectMultimap(Player::getClub);
        listFilter.block().forEach((club, player) -> {
            assert player.size() == 9;
        });
    }

    @Test
    void reactive_filtrarNacionalidadYRanking() {
        Flux<Player> listFlux = Flux.fromStream(list.parallelStream()).cache();
        Mono<Map<String, Collection<Player>>> listFilter = listFlux
                .map(player -> {
                    player.name = player.name.toUpperCase(Locale.ROOT);
                    return player;
                })
                .sort((player, b)->player.winners)
                .distinct()
                .collectMultimap(Player::getNational);
        listFilter.block().forEach((national, players) -> {
            System.out.println("\n"+national);
            players.stream().forEach(player -> System.out.println(player.name +" - Partidos ganados: "+player.winners));
        });
    }

    @Test
    void prueba(){
        Mono<String> a = Mono.just("a").delaySubscription(s -> DateOperators.Millisecond);
    }





}
