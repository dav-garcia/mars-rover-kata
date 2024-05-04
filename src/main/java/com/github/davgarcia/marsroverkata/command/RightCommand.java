package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.Direction;
import com.github.davgarcia.marsroverkata.Position;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class RightCommand implements Command {

    @Override
    public Position applyTo(final Position position) {
        return new Position(position.x(), position.y(), Direction.valueOf(position.direction().getRight()));
    }

    @Override
    public String toString() {
        return "R";
    }
}
