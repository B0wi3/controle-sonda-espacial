package com.sondas.desafio_elo7.service;

import com.sondas.desafio_elo7.model.Planet;
import com.sondas.desafio_elo7.model.Probe;
import com.sondas.desafio_elo7.repository.ProbeDAO;
import org.springframework.stereotype.Service;

@Service
public class ProbeService {

    private Probe probe;
    private ProbeDAO probeDAO;

    public Probe executeCommands(int id, String commands) {
        Probe probe = probeDAO.findById(id);
        if (probe != null) probe.move(commands);
        return probe;
    }

    public Probe get(int id) {
        return probeDAO.findById(id);
    }

    public Probe landProbe(Probe probe, Planet planet) {
        probe.setPlanet(planet);
        probeDAO.save(probe);
        return probe;
    }
}
