package com.sondas.desafio_elo7.service;

import com.sondas.desafio_elo7.model.Planet;
import com.sondas.desafio_elo7.repository.PlanetDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private PlanetDAO planetDAO;

    public PlanetService(PlanetDAO planetDAO) {
        this.planetDAO = planetDAO;
    }

    public Planet findByName(String name) {
        return planetDAO.findByName(name);
    }

    public Planet get(String name) {
        return planetDAO.findByName(name);
    }

    public List<Planet> list() {
        return planetDAO.list();
    }

    public Planet create(Planet planet) {
        return planetDAO.save(planet.getName(), planet.getHeight(), planet.getWidth());
    }

}
