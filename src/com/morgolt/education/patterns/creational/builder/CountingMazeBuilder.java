package com.morgolt.education.patterns.creational.builder;

public class CountingMazeBuilder extends MazeBuilder {

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
