package com.morgolt.education.builder;

import com.morgolt.education.labyrinth.Maze;

// MazeGame with using of Builder pattern.

public class MazeGame {

    public Maze createMaze(MazeBuilder builder) {
        builder.buildMaze();

        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);

        return builder.getMaze();
    }
}
