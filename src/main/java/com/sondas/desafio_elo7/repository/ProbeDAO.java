package com.sondas.desafio_elo7.repository;

import com.sondas.desafio_elo7.model.Probe;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class ProbeDAO {

    private List<Probe> probes = new ArrayList<>();
    private int nextId = 1;

    public void save(Probe probe) {
        probe.setId(nextId++);
        probes.add(probe);
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
