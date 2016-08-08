package com.morgolt.education.singleton;

import com.morgolt.education.labyrinth.Door;
import com.morgolt.education.labyrinth.Maze;
import com.morgolt.education.labyrinth.Room;
import com.morgolt.education.labyrinth.Wall;

// both AbstractFactory and ConcreteFactory. Could be made as interface or abstract class in different scenarios.

public class MazeFactory {

    private static MazeFactory instance = null;

    protected MazeFactory() {
        super();
    }

    public MazeFactory getInstance() {

        // there can be "style" choosing from environment variables
        // or singleton register to create another types of mazes
        if (null != instance) {
            instance = new MazeFactory();
        }
        return instance;
    }

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
