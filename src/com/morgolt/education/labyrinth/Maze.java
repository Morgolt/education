package com.morgolt.education.labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private final List<Room> rooms = new ArrayList<>();

    public Room findRoomByNumber(int number) {
        return rooms.get(number);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
