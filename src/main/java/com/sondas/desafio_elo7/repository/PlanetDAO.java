package com.sondas.desafio_elo7.repository;

import com.sondas.desafio_elo7.model.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetDAO {

    private List<Planet> planets;
    private int nextId = 1;

    public Planet save(int id, String name, int height, int width) {
        Planet planet = new Planet(nextId, name, height, width);
        planets.add(planet);
        return planet;
    }

    public List<Planet> list() {
        return new ArrayList<>(planets);
    }

    public Planet findById(int id) {
        return planets.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
