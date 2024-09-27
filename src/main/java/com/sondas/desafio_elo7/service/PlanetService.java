package com.sondas.desafio_elo7.service;

import com.sondas.desafio_elo7.model.Planet;
import com.sondas.desafio_elo7.repository.PlanetDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private PlanetDAO planetDAO;

    public Planet get(int id) {
        return planetDAO.findById(id);
    }

    public List<Planet> list() {
        return planetDAO.list();
    }

}
