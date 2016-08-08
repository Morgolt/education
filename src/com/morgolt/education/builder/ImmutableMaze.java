package com.morgolt.education.builder;

import com.morgolt.education.labyrinth.Direction;
import com.morgolt.education.labyrinth.Door;
import com.morgolt.education.labyrinth.Room;
import com.morgolt.education.labyrinth.Wall;

import java.util.ArrayList;
import java.util.List;

public class ImmutableMaze {

    private final List<Room> rooms;

    private ImmutableMaze(List<Room> rooms) {
        this.rooms = rooms;
    }

    static class Builder {
        private final List<Room> rooms = new ArrayList<>();

        Builder addRoom(int roomNumber) {
            Room room = new Room(roomNumber);

            room.setSide(Direction.North, new Wall());
            room.setSide(Direction.East, new Wall());
            room.setSide(Direction.South, new Wall());
            room.setSide(Direction.West, new Wall());

            rooms.add(room);
            return this;
        }

        public Builder addDoor(int roomFrom, int roomTo) {
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
