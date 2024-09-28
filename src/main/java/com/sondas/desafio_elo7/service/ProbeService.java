package com.sondas.desafio_elo7.service;

import com.sondas.desafio_elo7.model.Planet;
import com.sondas.desafio_elo7.model.Probe;
import com.sondas.desafio_elo7.repository.PlanetDAO;
import com.sondas.desafio_elo7.repository.ProbeDAO;
import org.springframework.stereotype.Service;

@Service
public class ProbeService {

    private ProbeDAO probeDAO;
    private PlanetDAO planetDAO;

    public ProbeService(ProbeDAO probeDAO, PlanetDAO planetDAO) {
        this.probeDAO = probeDAO;
        this.planetDAO = planetDAO;
    }

    public Probe executeCommands(String name, String commands) {
        Probe probe = probeDAO.findByName(name);
        if (probe != null) {
            probe.move(commands);
            return probe;
        }
        return null;
    }

    public Probe get(int id) {
        return probeDAO.findById(id);
    }

    public Probe findByName(String name) {
        return probeDAO.findByName(name);
    }

    public Probe landProbe(String probeName, String planetName) {
        Planet planet = planetDAO.findByName(planetName);
        Probe probe = probeDAO.findByName(probeName);
        probe.setPlanet(planet);
        probeDAO.save(probe);
        return probe;
    }

    public Probe create(String name) {
        Probe probe = new Probe(name);
        probeDAO.save(probe);
        return probe;
    }
}
