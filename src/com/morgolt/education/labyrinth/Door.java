package com.morgolt.education.labyrinth;

public class Door extends MapSite implements Cloneable {

    private Room room1;
    private Room room2;
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

    @Override
    public Door clone() {
        try {
            return (Door) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public void initialize(Room r1, Room r2) {
        room1 = r1.clone();
        room2 = r2.clone();
    }
}
