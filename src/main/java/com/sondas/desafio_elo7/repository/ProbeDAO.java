package com.sondas.desafio_elo7.repository;

import com.sondas.desafio_elo7.model.Probe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProbeDAO {

    private List<Probe> probes = new ArrayList<>();
    private int nextId = 1;

    public void save(Probe probe) {
        probe.setId(nextId++);
        probes.add(probe);
    }

    public Probe findByName(String name) {
        return probes.stream()
                .filter(probe -> Objects.equals(probe.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public Probe findById(int id) {
        return probes.stream()
                .filter(probe -> probe.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Probe> list() {
        return new ArrayList<>(probes);
    }

}
