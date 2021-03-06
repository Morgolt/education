package com.morgolt.education.patterns.creational.abstractfactory;

import com.morgolt.education.patterns.creational.labyrinth.Direction;
import com.morgolt.education.patterns.creational.labyrinth.Door;
import com.morgolt.education.patterns.creational.labyrinth.Maze;
import com.morgolt.education.patterns.creational.labyrinth.Room;

// MazeGame with using of AbstractFactory pattern.

public class MazeGame {

    public Maze createMaze(MazeFactory factory) {
        Maze maze = factory.makeMaze();
        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);
        Door theDoor = factory.makeDoor(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(Direction.North, factory.makeWall());
        r1.setSide(Direction.East, theDoor);
        r1.setSide(Direction.South, factory.makeWall());
        r1.setSide(Direction.West, factory.makeWall());

        r2.setSide(Direction.North, factory.makeWall());
        r2.setSide(Direction.East, factory.makeWall());
        r2.setSide(Direction.South, factory.makeWall());
        r2.setSide(Direction.West, theDoor);

        return maze;
    }
}
