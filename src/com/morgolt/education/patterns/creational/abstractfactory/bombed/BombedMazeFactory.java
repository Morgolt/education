package com.morgolt.education.patterns.creational.abstractfactory.bombed;

import com.morgolt.education.patterns.creational.abstractfactory.MazeFactory;
import com.morgolt.education.patterns.creational.labyrinth.Room;
import com.morgolt.education.patterns.creational.labyrinth.Wall;

public class BombedMazeFactory extends MazeFactory {

    @Override
    public Room makeRoom(int number) {
        return new RoomWithABomb(number);
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }


    // Normally should be in another files. Make it inner for simplicity.

    public static class RoomWithABomb extends Room {
        public RoomWithABomb(int number) {
            super(number);
        }
    }

    public static class BombedWall extends Wall {
    }
}
