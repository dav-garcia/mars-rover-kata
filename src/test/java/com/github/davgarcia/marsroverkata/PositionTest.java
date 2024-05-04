package com.github.davgarcia.marsroverkata;

import com.github.davgarcia.marsroverkata.error.InvalidPositionFormatException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void given_1_2_W_when_parse_then_return_position() {
        final var result = Position.fromString("1:2:W");

        assertThat(result.x()).isEqualTo(1);
        assertThat(result.y()).isEqualTo(2);
        assertThat(result.direction()).isEqualTo(Direction.W);
    }

    @Test
    void given_bad_x_when_parse_then_fail() {
        assertThrows(InvalidPositionFormatException.class, () -> Position.fromString("X:1:N"));
    }

    @Test
    void given_bad_y_when_parse_then_fail() {
        assertThrows(InvalidPositionFormatException.class, () -> Position.fromString("1:X:N"));
    }

    @Test
    void given_bad_direction_when_parse_then_fail() {
        assertThrows(InvalidPositionFormatException.class, () -> Position.fromString("1:1:X"));
    }

    @Test
    void given_missing_direction_when_parse_then_fail() {
        assertThrows(InvalidPositionFormatException.class, () -> Position.fromString("1:2"));
    }

    @Test
    void given_position_when_tostring_then_return_string() {
        final var position = new Position(1, 2, Direction.W);

        final var result = position.toString();

        assertThat(result).isEqualTo("1:2:W");
    }
}
