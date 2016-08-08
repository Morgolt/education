package com.morgolt.education.factorymethod;

import com.morgolt.education.abstractfactory.bombed.BombedMazeFactory;
import com.morgolt.education.labyrinth.Room;
import com.morgolt.education.labyrinth.Wall;

public class BombedMazeGame extends MazeGame {

    @Override
    Wall makeWall() {
        return new BombedMazeFactory.BombedWall();
    }

    @Override
    Room makeRoom(int n) {
        return new BombedMazeFactory.RoomWithABomb(n);
    }
}
