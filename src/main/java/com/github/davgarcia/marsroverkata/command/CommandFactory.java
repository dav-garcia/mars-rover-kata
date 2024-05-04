package com.github.davgarcia.marsroverkata.command;

import com.github.davgarcia.marsroverkata.error.InvalidCommandFormatException;

import java.util.ArrayList;

public class CommandFactory {

    public Command moveCommand() {
        return new MoveCommand();
    }

    public Command leftCommand() {
        return new LeftCommand();
    }

    public Command rightCommand() {
        return new RightCommand();
    }

    public Command fromString(final String command) {
        final var list = new ArrayList<Command>(command.length());
        for (var letter: command.toCharArray()) {
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
