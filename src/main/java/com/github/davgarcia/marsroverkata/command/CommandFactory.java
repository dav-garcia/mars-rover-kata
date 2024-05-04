package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.error.InvalidCommandFormatException;

import java.util.ArrayList;
import java.util.Optional;

public class CommandFactory {

    private final Command moveCommand;
    private final Command leftCommand;
    private final Command rightCommand;

    public CommandFactory() {
        moveCommand = new MoveCommand();
        leftCommand = new LeftCommand();
        rightCommand = new RightCommand();
    }

    public Command moveCommand() {
        return moveCommand;
    }

    public Command leftCommand() {
        return leftCommand;
    }

    public Command rightCommand() {
        return rightCommand;
    }

    public Command fromString(final String command) {
        final var nonNullCommand = Optional.ofNullable(command).orElse("");
        final var list = new ArrayList<Command>(nonNullCommand.length());

        for (var letter: nonNullCommand.toCharArray()) {
            switch (letter) {
                case 'M':
                    list.add(moveCommand());
                    break;
                case 'L':
                    list.add(leftCommand());
                    break;
                case 'R':
                    list.add(rightCommand());
                    break;
                default:
                    throw new InvalidCommandFormatException("Not a valid command: " + letter);
            }
        }
        return new CommandSequence(list);
    }
}
