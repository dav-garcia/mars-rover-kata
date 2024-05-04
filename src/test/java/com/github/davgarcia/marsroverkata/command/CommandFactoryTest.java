package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.error.InvalidCommandFormatException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandFactoryTest {

    @Test
    void given_empty_string_when_parse_then_return_empty_sequence() {
        final var factory = new CommandFactory();

        final var result = factory.fromString("");

        assertThat(result).isEqualTo(new CommandSequence(Collections.emptyList()));
    }

    @Test
    void given_M_M_L_M_R_M_when_parse_then_return_sequence() {
        final var factory = new CommandFactory();

        final var result = factory.fromString("MMLMRM");

        assertThat(result).isEqualTo(new CommandSequence(List.of(
                factory.moveCommand(),
                factory.moveCommand(),
                factory.leftCommand(),
                factory.moveCommand(),
                factory.rightCommand(),
                factory.moveCommand())));
    }

    @Test
    void given_unknown_command_when_parse_then_fail() {
        final var factory = new CommandFactory();

        assertThrows(InvalidCommandFormatException.class, () -> factory.fromString("MLRX"));
    }
}
