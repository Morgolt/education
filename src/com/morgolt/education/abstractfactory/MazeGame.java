package com.morgolt.education.abstractfactory;

import com.morgolt.education.labyrinth.Direction;
import com.morgolt.education.labyrinth.Door;
import com.morgolt.education.labyrinth.Maze;
import com.morgolt.education.labyrinth.Room;

// MazeGame with using of AbstractFactory pattern.

public class MazeGame {

    Maze createMaze(MazeFactory factory) {
        Maze maze = factory.makeMaze();
        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);
        Door theDoor = factory.makeDoor(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.SetSide(Direction.North, factory.makeWall());
        r1.SetSide(Direction.East, theDoor);
        r1.SetSide(Direction.South, factory.makeWall());
        r1.SetSide(Direction.West, factory.makeWall());

        r2.SetSide(Direction.North, factory.makeWall());
        r2.SetSide(Direction.East, factory.makeWall());
        r2.SetSide(Direction.South, factory.makeWall());
        r2.SetSide(Direction.West, theDoor);

        return maze;
    }
}
