package com.morgolt.education.labyrinth;

import java.util.Arrays;

@SuppressWarnings("EmptyMethod")
public class Room extends MapSite implements Cloneable {

    private MapSite[] sides = new MapSite[4]; //NESW
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public MapSite getSide(Direction direction) {
        return this;
    }

    public void setSide(Direction direction, MapSite side) {
        switch(direction) {
            case North:
                sides[0] = side;
            case East:
                sides[1] = side;
            case South:
                sides[2] = side;
            case West:
                sides[3] = side;
            default:
                break;
        }

    }

    @Override
    public void enter() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomNumber != room.roomNumber) return false;

        //

        return (room.getSide(Direction.North).getClass().equals(getSide(Direction.North).getClass()) &&
                room.getSide(Direction.South).getClass().equals(getSide(Direction.South).getClass()) &&
                room.getSide(Direction.West).getClass().equals(getSide(Direction.West).getClass()) &&
                room.getSide(Direction.East).getClass().equals(getSide(Direction.East).getClass()));

    }

    @Override
    public Room clone() {
        try {
            return (Room) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(sides);
        result = 31 * result + roomNumber;
        return result;
    }

    public void initialize(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
