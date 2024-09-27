package com.sondas.desafio_elo7.controller;

import com.sondas.desafio_elo7.model.Planet;
import com.sondas.desafio_elo7.service.PlanetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    private PlanetService planetService;

    @GetMapping
    public Planet planet(@PathVariable int id) {
        return planetService.get(id);
    }

    @GetMapping("/list")
    public List<Planet> list() {
        return planetService.list();
    }

}
