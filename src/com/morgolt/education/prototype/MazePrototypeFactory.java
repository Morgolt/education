package com.morgolt.education.prototype;

import com.morgolt.education.abstractfactory.MazeFactory;
import com.morgolt.education.labyrinth.Door;
import com.morgolt.education.labyrinth.Maze;
import com.morgolt.education.labyrinth.Room;
import com.morgolt.education.labyrinth.Wall;

public class MazePrototypeFactory extends MazeFactory {

    private Maze prototypeMaze;
    private Room prototypeRoom;
    private Wall prototypeWall;
    private Door prototypeDoor;

    public MazePrototypeFactory(Maze prototypeMaze, Room prototypeRoom, Wall prototypeWall, Door prototypeDoor) {
        this.prototypeMaze = prototypeMaze;
        this.prototypeRoom = prototypeRoom;
        this.prototypeWall = prototypeWall;
        this.prototypeDoor = prototypeDoor;
    }

    @Override
    public Wall makeWall() {
        return prototypeWall.clone();
    }

    @Override
    public Room makeRoom(int number) {
        Room room = prototypeRoom.clone();
        room.initialize(number);
        return room;
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        Door door = prototypeDoor.clone();
        door.initialize(r1, r2);
        return door;
    }

    @Override
    public Maze makeMaze() {
        return prototypeMaze.clone();
    }
}
