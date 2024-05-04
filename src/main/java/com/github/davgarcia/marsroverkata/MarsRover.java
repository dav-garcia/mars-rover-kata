package com.github.davgarcia.marsroverkata;

public interface MarsRover {

    MarsRoverPosition execute(String command);

    MarsRoverPosition currentPosition();
}
