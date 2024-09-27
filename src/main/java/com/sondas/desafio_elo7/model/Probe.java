package com.sondas.desafio_elo7.model;

public class Probe {

    private Coordinates coordinates;
    private Planet planet;
    private char direction;
    private int id;

    public Probe(Coordinates coordinates, Planet planet, char direction, int id) {
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
                ": coordinates = " + coordinates +
                ", direction = " + direction +
                ", planet = " + planet +
                '.';
    }
}
