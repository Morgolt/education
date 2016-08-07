package com.morgolt.education.labyrinth;

@SuppressWarnings("EmptyMethod")
public class Room extends MapSite {

    private MapSite[] sides = new MapSite[4];
    private final int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public MapSite getSide(Direction direction) {
        return this;
    }

    public void setSide(Direction direction, MapSite side) {

    }

    @Override
    public void enter() {

    }
}
