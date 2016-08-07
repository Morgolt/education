package com.morgolt.education.builder;

import com.morgolt.education.labyrinth.Direction;
import com.morgolt.education.labyrinth.Door;
import com.morgolt.education.labyrinth.Room;

import java.util.ArrayList;
import java.util.List;

class ImmutableMaze {

    private final List<Room> rooms;

    private ImmutableMaze(List<Room> rooms) {
        this.rooms = rooms;
    }

    static class Builder {
        private final List<Room> rooms = new ArrayList<>();

        Builder addRoom(int room) {
            rooms.add(new Room(room));
            return this;
        }

        Builder addDoor(int roomFrom, int roomTo) {
            Room r1 = rooms.get(roomFrom);
            Room r2 = rooms.get(roomTo);
            Door door = new Door(r1, r2);

            r1.setSide(commonWall(r1, r2), door);
            r2.setSide(commonWall(r2, r1), door);

            return this;
        }

        ImmutableMaze build() {
            return new ImmutableMaze(rooms);
        }

        private Direction commonWall(Room r1, Room r2) {
            return Direction.North;

        }
    }


}
