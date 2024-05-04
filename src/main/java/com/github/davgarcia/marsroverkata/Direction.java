package com.github.davgarcia.marsroverkata;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal=true, level= AccessLevel. PRIVATE)
@AllArgsConstructor
public enum Direction {
    N(0, 1, "W", "E"),
    E(1, 0, "N", "S"),
    W(-1, 0, "S", "N"),
    S(0, -1, "E", "W");

    int xIncrement;
    int yIncrement;
    String left;
    String right;
}
