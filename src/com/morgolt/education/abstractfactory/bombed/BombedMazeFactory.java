package com.morgolt.education.abstractfactory.bombed;

import com.morgolt.education.abstractfactory.MazeFactory;
import com.morgolt.education.labyrinth.Room;
import com.morgolt.education.labyrinth.Wall;

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

    private class RoomWithABomb extends Room {
        RoomWithABomb(int number) {
            super(number);
        }
    }

    private class BombedWall extends Wall {
    }
}
