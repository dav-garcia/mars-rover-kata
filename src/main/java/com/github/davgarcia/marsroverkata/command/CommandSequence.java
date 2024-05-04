package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.Position;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class CommandSequence implements Command {

    private final List<Command> sequence;

    public CommandSequence(final List<Command> sequence) {
        this.sequence = sequence;
    }

    @Override
    public Position applyTo(final Position position) {
        var result = position;
        for (var command: sequence) {
            result = command.applyTo(result);
        }
        return result;
    }

    @Override
    public String toString() {
        return sequence.stream()
                .map(Command::toString)
                .collect(Collectors.joining());
    }
}
