package com.morgolt.education.labyrinth;

public class Door extends MapSite {

    private final Room room1;
    private final Room room2;
    private boolean isOpen;

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    @Override
    public void enter() {

    }

    Room otherSideFrom(Room room) {
        return room1;
    }
}
