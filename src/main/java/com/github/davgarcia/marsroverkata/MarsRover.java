package com.github.davgarcia.marsroverkata;

import com.github.davgarcia.marsroverkata.command.Command;

public interface MarsRover {

    Position execute(Command command);

    Position currentPosition();
}
