package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.Position;

public interface Command {

    Position applyTo(final Position position);
}
