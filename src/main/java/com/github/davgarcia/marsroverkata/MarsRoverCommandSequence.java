package com.github.davgarcia.marsroverkata;

import java.util.List;

public class MarsRoverCommandSequence implements MarsRoverCommand {

    private final List<MarsRoverCommand> sequence;

    public MarsRoverCommandSequence(final List<MarsRoverCommand> sequence) {
        this.sequence = sequence;
    }

    @Override
    public void submitTo(final MarsRover marsRover) {
        //sequence.forEach(marsRover::execute);
    }
}
