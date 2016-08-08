package com.morgolt.education.labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private final List<Room> rooms = new ArrayList<>();

    public Room findRoomByNumber(int number) {
        try {
            return rooms.get(number - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maze maze = (Maze) o;

        return rooms != null ? rooms.equals(maze.rooms) : maze.rooms == null;

    }

    @Override
    public int hashCode() {
        return rooms != null ? rooms.hashCode() : 0;
    }
}
