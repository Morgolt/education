package com.morgolt.education.abstractfactory;

import com.morgolt.education.labyrinth.Door;
import com.morgolt.education.labyrinth.Maze;
import com.morgolt.education.labyrinth.Room;
import com.morgolt.education.labyrinth.Wall;

// both AbstractFactory and ConcreteFactory. Could be made as interface or abstract class in different scenarios.

public class MazeFactory {

    public Maze makeMaze() {
        return new Maze();
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Room makeRoom(int number) {
        return new Room(number);
    }

    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
