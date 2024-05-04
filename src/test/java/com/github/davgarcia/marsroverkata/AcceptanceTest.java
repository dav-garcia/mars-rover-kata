package com.github.davgarcia.marsroverkata;

import com.github.davgarcia.marsroverkata.command.CommandFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AcceptanceTest {

    private static final CommandFactory FACTORY = new CommandFactory();

    @Test
    void given_M_when_execute_then_0_1_N() {
        final var marsRover = new DefaultMarsRover();

        final var result = marsRover.execute(FACTORY.moveCommand());

        assertThat(result).hasToString("0:1:N");

    }

    @Test
    void given_MMRMMLM_when_execute_then_2_3_N() {
        final var marsRover = new DefaultMarsRover();

        final var result = marsRover.execute(FACTORY.fromString("MMRMMLM"));

        assertThat(result).hasToString("2:3:N");
    }

    @Test
    void given_new_rover_when_get_position_then_0_0_N() {
        final var marsRover = new DefaultMarsRover();

        final var result = marsRover.currentPosition();

        assertThat(result).hasToString("0:0:N");
    }
}
