package com.github.davgarcia.marsroverkata;

import com.github.davgarcia.marsroverkata.command.CommandFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AcceptanceTest {

    private static final Grid GRID = new Grid(10, 10);
    private static final CommandFactory FACTORY = new CommandFactory();

    @Test
    void given_M_when_execute_then_0_1_N() {
        final var marsRover = new DefaultMarsRover(GRID);

        final var result = marsRover.execute(FACTORY.moveCommand());

        assertThat(result).hasToString("0:1:N");
    }

    @Test
    void given_MR_and_ML_when_execute_then_1_1_N() {
        final var marsRover = new DefaultMarsRover(GRID);

        marsRover.execute(FACTORY.fromString("MR"));
        final var result = marsRover.execute(FACTORY.fromString("ML"));

        assertThat(result).hasToString("1:1:N");
    }

    @ParameterizedTest
    @CsvSource({
            "MMRMMLM,2:3:N",
            ",0:0:N",
            "RRMRM,9:9:W"})
    void given_command_when_execute_then_return_position(String inputCommand, String expectedResult) {
        final var marsRover = new DefaultMarsRover(GRID);

        final var result = marsRover.execute(FACTORY.fromString(inputCommand));

        assertThat(result).hasToString(expectedResult);
    }
}
