package com.github.davgarcia.marsroverkata;

import com.github.davgarcia.marsroverkata.command.Command;

public class DefaultMarsRover implements MarsRover {

    private Position currentPosition;

    public DefaultMarsRover() {
        currentPosition = new Position();
    }

    @Override
    public Position execute(final Command command) {
        currentPosition = command.applyTo(currentPosition);
        return currentPosition;
    }

    @Override
    public Position currentPosition() {
        return currentPosition;
    }
}
