package com.example.demo.Controller;

import com.example.demo.Collection.PlayerCollection;
import com.example.demo.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/clubMayor34")
    public Flux<List<PlayerCollection>> filtrarJugadoresMayoresA34PorUnClub(){
        return playerService.filtrarJugadoresMayoresA34PorUnClub();
    }

    @GetMapping("/clasificacion")
    public Flux<List<PlayerCollection>> filtrarJugadoresPorNacionalidadYRancking(){
        return playerService.filtrarJugadoresPorNacionalidadYRancking();
    }

}
