package com.morgolt.education.patterns.creational.factorymethod;

import com.morgolt.education.patterns.creational.abstractfactory.bombed.BombedMazeFactory;
import com.morgolt.education.patterns.creational.labyrinth.Room;
import com.morgolt.education.patterns.creational.labyrinth.Wall;

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
