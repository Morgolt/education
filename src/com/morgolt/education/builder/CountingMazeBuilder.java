package com.morgolt.education.builder;

class CountingMazeBuilder extends MazeBuilder {

    private int doorsCount;
    private int roomsCount;

    CountingMazeBuilder() {
        doorsCount = roomsCount = 0;
    }

    @Override
    void buildRoom(int number) {
        roomsCount++;
    }

    @Override
    void buildDoor(int roomFrom, int roomTo) {
        doorsCount++;
    }

    int getDoorsCount() {
        return doorsCount;
    }

    int getRoomsCount() {
        return roomsCount;
    }
}
