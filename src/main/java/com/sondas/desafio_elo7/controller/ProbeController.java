package com.sondas.desafio_elo7.controller;

import com.sondas.desafio_elo7.Exception.OutOfPlanetBoundsException;
import com.sondas.desafio_elo7.model.Planet;
import com.sondas.desafio_elo7.model.Probe;
import com.sondas.desafio_elo7.service.PlanetService;
import com.sondas.desafio_elo7.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private PlanetService planetService;
    @Autowired
    private ProbeService probeService;

    @GetMapping("/{id}")
    public Probe getProbe(@PathVariable int id) {
        return probeService.get(id);
    }

    @PutMapping("/{name}/move")
    public ResponseEntity<?> moveProbe(@PathVariable String name, @RequestParam String commands) {
        try {
            Probe probe = probeService.executeCommands(name, commands);
            return ResponseEntity.ok(probe);
        } catch (OutOfPlanetBoundsException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/{name}")
    public Probe create(@PathVariable String name) {
        return probeService.create(name);
    }

    @PostMapping("/land")
    public ResponseEntity<Probe> landNewProbe(@RequestParam String probeName, String planetName) {
        probeService.landProbe(probeName, planetName);
        Probe probe = probeService.findByName(probeName);
        Planet planet = planetService.findByName(planetName);
        if (Objects.equals(probe.getPlanet().getName(), planetName)) {
            return ResponseEntity.ok(probe);
        }
        return ResponseEntity.badRequest().build();
    }

}
