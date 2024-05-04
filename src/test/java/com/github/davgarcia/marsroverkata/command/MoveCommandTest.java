package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.Position;
import org.junit.jupiter.api.Test;

import static com.github.davgarcia.marsroverkata.Direction.E;
import static com.github.davgarcia.marsroverkata.Direction.N;
import static com.github.davgarcia.marsroverkata.Direction.S;
import static com.github.davgarcia.marsroverkata.Direction.W;
import static org.assertj.core.api.Assertions.assertThat;

class MoveCommandTest {

    @Test
    void given_north_when_apply_then_increment_y() {
        final var command = new MoveCommand();
        final var position = new Position(0, 0, N);

        final var result = command.applyTo(position);

        assertThat(result).isEqualTo(new Position(0, 1, N));
    }

    @Test
    void given_east_when_apply_then_increment_x() {
        final var command = new MoveCommand();
        final var position = new Position(0, 0, E);

        final var result = command.applyTo(position);

        assertThat(result).isEqualTo(new Position(1, 0, E));
    }

    @Test
    void given_west_when_apply_then_decrement_x() {
        final var command = new MoveCommand();
        final var position = new Position(0, 0, W);

        final var result = command.applyTo(position);

        assertThat(result).isEqualTo(new Position(-1, 0, W));
    }

    @Test
    void given_south_when_apply_then_decrement_y() {
        final var command = new MoveCommand();
        final var position = new Position(0, 0, S);

        final var result = command.applyTo(position);

        assertThat(result).isEqualTo(new Position(0, -1, S));
    }
}
