package com.sondas.desafio_elo7.model;

public class Planet {

    private int height;
    private int width;

    public Planet(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public boolean isCoordinateValid(Coordinates coordinates) {
        return !(coordinates.getX() > width) && coordinates.getX() >= 0 &&
                !(coordinates.getY() > height) && coordinates.getY() >= 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Planet area: " +
                "height = " + height +
                ", width = " + width +
                '.';
    }
}
