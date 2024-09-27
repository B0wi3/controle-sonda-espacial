package com.sondas.desafio_elo7.controller;

import com.sondas.desafio_elo7.model.Planet;
import com.sondas.desafio_elo7.model.Probe;
import com.sondas.desafio_elo7.service.ProbeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/probe")
public class ProbeController {

    private ProbeService probeService;

    @PostMapping

    @GetMapping("/{id}")
    public Probe getProbe(@PathVariable int id) {
        return probeService.get(id);
    }

    @PutMapping("/{id}/move")
    public Probe moveProbe(@PathVariable int id, @RequestBody String commands) {
        return probeService.executeCommands(id, commands);
    }

    @PostMapping
    public Probe landNewProbe(@RequestBody Probe probe, Planet planet) {
        return probeService.landProbe(probe, planet);
    }

}
