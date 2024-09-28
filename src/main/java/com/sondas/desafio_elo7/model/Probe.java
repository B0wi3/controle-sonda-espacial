package com.sondas.desafio_elo7.model;

import com.sondas.desafio_elo7.Exception.OutOfPlanetBoundsException;

public class Probe {

    private String name;
    private Coordinates coordinates;
    private Planet planet;
    private char direction;
    private int id;


    public Probe(String name) {
        this.name = name;
        this.coordinates = new Coordinates(0, 0);
        this.direction = 'N';
    }

    // Move probe
    public void move(String commands) {
        for (char command: commands.toCharArray()) {
            switch (command) {
                case 'M':
                    moveForward();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
            }
        }
    }

    public void moveForward() {
        // Dependendo da direção, ajuste as coordenadas
        switch (direction) {
            case 'N':
                if (coordinates.getY() + 1 > planet.getHeight()) {
                    throw new OutOfPlanetBoundsException("The probe tried to leave the planet area!");
                }
                coordinates.setY(coordinates.getY() + 1);
                break;
            case 'S':
                if (coordinates.getY() - 1 < 0) {
                    throw new OutOfPlanetBoundsException("The probe tried to leave the planet area!");
                }
                coordinates.setY(coordinates.getY() - 1);
                break;
            case 'E':
                if (coordinates.getX() + 1 > planet.getWidth()) {
                    throw new OutOfPlanetBoundsException("The probe tried to leave the planet area!");
                }
                coordinates.setX(coordinates.getX() + 1);
                break;
            case 'W':
                if (coordinates.getX() - 1 < 0) {
                    throw new OutOfPlanetBoundsException("The probe tried to leave the planet area!");
                }
                coordinates.setX(coordinates.getX() - 1);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    private void turnLeft() {
        switch(direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    private void turnRight() {
        switch(direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Probe " + id +
                ": name = " + name +
                " coordinates = " + coordinates +
                ", direction = " + direction +
                ", planet = " + planet +
                '.';
    }
}
