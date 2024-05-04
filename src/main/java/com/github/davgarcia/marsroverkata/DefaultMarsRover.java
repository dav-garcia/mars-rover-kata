package com.github.davgarcia.marsroverkata;

import com.github.davgarcia.marsroverkata.command.Command;

public class DefaultMarsRover implements MarsRover {

    private final Grid grid;
    private Position currentPosition;

    public DefaultMarsRover(final Grid grid) {
        this.grid = grid;
        currentPosition = new Position();
    }

    @Override
    public Position execute(final Command command) {
        currentPosition = grid.wrapToGrid(command.applyTo(currentPosition));
        return currentPosition;
    }

    @Override
    public Position currentPosition() {
        return currentPosition;
    }
}
