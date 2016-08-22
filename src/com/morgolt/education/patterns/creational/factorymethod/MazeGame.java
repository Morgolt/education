package com.morgolt.education.patterns.creational.factorymethod;

import com.morgolt.education.patterns.creational.labyrinth.*;

public class MazeGame {

    public Maze createMaze() {
        Maze maze = makeMaze();

        Room r1 = makeRoom(1);
        Room r2 = makeRoom(2);
        Door theDoor = makeDoor(r1, r2);

        r1.setSide(Direction.North, makeWall());
        r1.setSide(Direction.East, makeWall());
        r1.setSide(Direction.South, makeWall());
        r1.setSide(Direction.West, makeWall());

        r2.setSide(Direction.North, makeWall());
        r2.setSide(Direction.East, makeWall());
        r2.setSide(Direction.South, makeWall());
        r2.setSide(Direction.West, theDoor);

        maze.addRoom(r1);
        maze.addRoom(r2);
        return maze;
    }

    Maze makeMaze() {
        return new Maze();
    }

    Room makeRoom(int n) {
        return new Room(n);
    }

    Wall makeWall() {
        return new Wall();
    }

    Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
