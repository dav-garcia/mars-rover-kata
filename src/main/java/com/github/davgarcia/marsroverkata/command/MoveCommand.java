package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.Position;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MoveCommand implements Command {

    @Override
    public Position applyTo(final Position position) {
        final var direction = position.direction();
        final var x = position.x() + direction.getXIncrement();
        final var y = position.y() + direction.getYIncrement();
        return new Position(x, y, direction);
    }

    @Override
    public String toString() {
        return "M";
    }
}
