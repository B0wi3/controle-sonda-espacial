package com.sondas.desafio_elo7.repository;

import com.sondas.desafio_elo7.model.Planet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlanetDAO {

    private List<Planet> planets = new ArrayList<>();

    public Planet save(String name, int height, int width) {
        Planet planet = new Planet(name, height, width);
        planets.add(planet);
        return planet;
    }

    public List<Planet> list() {
        return new ArrayList<>(planets);
    }

    public Planet findByName(String name) {
        return planets.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
