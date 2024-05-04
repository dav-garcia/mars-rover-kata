package com.github.davgarcia.marsroverkata;

import com.github.davgarcia.marsroverkata.error.InvalidPositionFormatException;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public record Position(int x, int y, Direction direction) {

    @NotNull
    public static Position fromString(final String position) {
        final var parts = StringUtils.split(position, ':');

        if (parts.length != 3) {
            throw new InvalidPositionFormatException("Bad split: " + position);
        }

        try {
            final var x = Integer.parseInt(parts[0]);
            final var y = Integer.parseInt(parts[1]);
            final var direction = Direction.valueOf(parts[2]);
            return new Position(x, y, direction);
        } catch (NumberFormatException e) {
            throw new InvalidPositionFormatException("Not a number: " + position, e);
        } catch (IllegalArgumentException e) {
            throw new InvalidPositionFormatException("Not a direction: " + position, e);
        }
    }

    public Position() {
        this(0, 0, Direction.N);
    }

    @Override
    public String toString() {
        return String.join(":", Integer.toString(x), Integer.toString(y), direction.name());
    }
}
