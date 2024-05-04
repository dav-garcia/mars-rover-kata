package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.Position;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MoveCommand implements Command {

    @Override
    public Position applyTo(final Position position) {
        final var direction = position.direction();
        return new Position(position.x() + direction.getXIncrement(), position.y() + direction.getYIncrement(), direction);
    }

    @Override
    public String toString() {
        return "M";
    }
}
