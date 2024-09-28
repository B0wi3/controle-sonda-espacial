package com.sondas.desafio_elo7.controller;

import com.sondas.desafio_elo7.model.Planet;
import com.sondas.desafio_elo7.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping("/{name}")
    public ResponseEntity<Planet> get(@PathVariable String name) {
        Planet planet = planetService.get(name);
        if (planet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(planet);
    }

    @GetMapping("/list")
    public List<Planet> list() {
        return planetService.list();
    }

    @PostMapping
    public Planet create(@RequestBody Planet planet) {
        return planetService.create(planet);
    }

}
