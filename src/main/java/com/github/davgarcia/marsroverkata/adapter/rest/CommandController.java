package com.github.davgarcia.marsroverkata.adapter.rest;

import com.github.davgarcia.marsroverkata.MarsRover;
import com.github.davgarcia.marsroverkata.MarsRoverPosition;

public class CommandController {

    private final MarsRover marsRover;

    public CommandController(final MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    public MarsRoverPosition execute(final String command) {
        return marsRover.execute(command);
    }
}
