package com.sondas.desafio_elo7.model;

public class Probe {

    private Coordinates coordinates;
    private Planet planet;
    private char direction;
    private Long id;

    public Probe(Coordinates coordinates, Planet planet, char direction, Long id) {
        this.coordinates = coordinates;
        this.planet = planet;
        this.direction = direction;
        this.id = id;
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

    private void moveForward() {
        Coordinates newCoordinates = new Coordinates(coordinates.getX(), coordinates.getY());
        switch (direction) {
            case 'N':
                newCoordinates.setY(coordinates.getY() + 1);
                break;
            case 'W':
                newCoordinates.setX(coordinates.getX() - 1);
                break;
            case 'S':
                newCoordinates.setY(coordinates.getY() - 1);
                break;
            case 'E':
                newCoordinates.setX(coordinates.getX() + 1);
                break;
        }
        if (planet.isCoordinateValid(newCoordinates)) {
            coordinates = newCoordinates;
        } else {
            System.out.println("Coordinates are outside planet area.");
        }
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
