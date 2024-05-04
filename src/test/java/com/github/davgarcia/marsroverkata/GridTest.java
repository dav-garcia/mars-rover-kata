package com.github.davgarcia.marsroverkata;

import org.junit.jupiter.api.Test;

import static com.github.davgarcia.marsroverkata.Direction.N;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void given_negative_x_when_wrap_then_return_max_x() {
        final var grid = new Grid(10, 10);
        final var position = new Position(-1, 5, N);

        final var result = grid.wrapToGrid(position);

        assertThat(result).isEqualTo(new Position(9, 5, N));
    }

    @Test
    void given_overvlow_x_when_wrap_then_return_0() {
        final var grid = new Grid(10, 10);
        final var position = new Position(10, 5, N);

        final var result = grid.wrapToGrid(position);

        assertThat(result).isEqualTo(new Position(0, 5, N));
    }

    @Test
    void given_negative_y_when_wrap_then_return_max_y() {
        final var grid = new Grid(10, 10);
        final var position = new Position(5, -1, N);

        final var result = grid.wrapToGrid(position);

        assertThat(result).isEqualTo(new Position(5, 9, N));
    }

    @Test
    void given_overflow_y_when_wrap_then_return_0() {
        final var grid = new Grid(10, 10);
        final var position = new Position(5, 10, N);

        final var result = grid.wrapToGrid(position);

        assertThat(result).isEqualTo(new Position(5, 0, N));
    }
}
