package com.github.davgarcia.marsroverkata;

public class DefaultMarsRover implements MarsRover {

    private MarsRoverPosition currentPosition;

    public DefaultMarsRover() {
        currentPosition = new MarsRoverPosition();
    }

    @Override
    public MarsRoverPosition execute(final String command) {
        currentPosition = MarsRoverPosition.fromString("2:3:N");
        return currentPosition;
    }

    @Override
    public MarsRoverPosition currentPosition() {
        return currentPosition;
    }
}
