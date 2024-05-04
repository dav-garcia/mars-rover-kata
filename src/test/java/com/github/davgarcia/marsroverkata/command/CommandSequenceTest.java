package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class CommandSequenceTest {

    @Test
    void given_empty_sequence_when_apply_then_do_nothing() {
        final var sequence = new CommandSequence(Collections.emptyList());
        final var position = Mockito.mock(Position.class);

        final var result = sequence.applyTo(position);

        assertThat(result).isSameAs(position);
    }

    @Test
    void given_sequence_of_2_when_apply_then_apply_each_in_order() {
        final var command1 = mock(Command.class);
        final var command2 = mock(Command.class);
        final var sequence = new CommandSequence(List.of(command1, command2));

        final var start = mock(Position.class);
        final var intermediate = mock(Position.class);
        final var finish = mock(Position.class);

        doReturn(intermediate).when(command1).applyTo(start);
        doReturn(finish).when(command2).applyTo(intermediate);

        final var result = sequence.applyTo(start);

        assertThat(result).isSameAs(finish);
    }

    @Test
    void given_sequence_when_tostring_then_return_string() {
        final var command = new CommandSequence(List.of(new MoveCommand(), new LeftCommand(), new RightCommand()));

        final var result = command.toString();

        assertThat(result).hasToString("MLR");
    }
}
