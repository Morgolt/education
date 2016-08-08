package com.morgolt.education.builder;

import com.morgolt.education.labyrinth.*;

public class StandardMazeBuilder extends MazeBuilder {

    private Maze currentMaze;

    public StandardMazeBuilder() {
        currentMaze = null;
    }

    @Override
    void buildMaze() {
        currentMaze = new Maze();
    }

    @Override
    Maze getMaze() {
        return currentMaze;
    }

    @Override
    void buildRoom(int number) {
        if (null == currentMaze.findRoomByNumber(number)) {
            Room room = new Room(number);

            room.setSide(Direction.North, new Wall());
            room.setSide(Direction.East, new Wall());
            room.setSide(Direction.South, new Wall());
            room.setSide(Direction.West, new Wall());

            currentMaze.addRoom(room);
        }
    }

    @Override
    void buildDoor(int roomFrom, int roomTo) {
        Room r1 = currentMaze.findRoomByNumber(roomFrom);
        Room r2 = currentMaze.findRoomByNumber(roomTo);
        Door door = new Door(r1, r2);

        r1.setSide(commonWall(r1, r2), door);
        r2.setSide(commonWall(r2, r1), door);
    }

    // determines direction of common wall between two rooms
    private Direction commonWall(Room r1, Room r2) {
        return Direction.North;
    }
}
