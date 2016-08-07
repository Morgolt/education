package com.morgolt.education.builder;

import com.morgolt.education.labyrinth.Maze;

// MazeGame with using of Builder pattern.

class MazeGame {

    private Maze createMaze(MazeBuilder builder) {
        builder.buildMaze();

        builder.buildRoom(1);
        builder.buildRoom(2);

        return builder.getMaze();
    }

    public static void main(String[] args) {
        Maze maze;
        MazeGame game = new MazeGame();
        StandardMazeBuilder builder = new StandardMazeBuilder();

        // standard maze builder
        game.createMaze(builder);
        maze = builder.getMaze();

        //counting maze builder
        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder();

        game.createMaze(countingMazeBuilder);
        System.out.println("Labyrinth has " + countingMazeBuilder.getRoomsCount() +
                " rooms and " + countingMazeBuilder.getDoorsCount() + " doors.");

        // chained builder
        ImmutableMaze immutableMaze = new ImmutableMaze.Builder().
                addRoom(1).
                addRoom(2).
                build();

    }



}
