package com.morgolt.education.labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    List<Room> rooms = new ArrayList<>();

    Room findRoomByNumber(int number) {
        return rooms.get(number);
    }

    void addRoom(Room room) {
        rooms.add(room);
    }
}
