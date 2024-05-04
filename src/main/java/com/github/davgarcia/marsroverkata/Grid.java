package com.github.davgarcia.marsroverkata;

public record Grid(int xSize, int ySize) {

    Position wrapToGrid(final Position position) {
        var x = position.x();
        var y = position.y();

        return new Position(wrapAround(x, xSize), wrapAround(y, ySize), position.direction());
    }

    private int wrapAround(final int value, final int size) {
        return ((value % size) + size) % size;
    }
}
