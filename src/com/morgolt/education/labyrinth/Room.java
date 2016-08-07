package com.morgolt.education.labyrinth;

public class Room extends MapSite {

    private MapSite[] sides = new MapSite[4];
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    MapSite GetSide(Direction direction) {
        return this;
    }

    void SetSide(Direction direction, MapSite side) {

    }

    @Override
    public void Enter() {

    }
}
