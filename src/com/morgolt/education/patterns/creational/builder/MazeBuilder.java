package com.morgolt.education.patterns.creational.builder;


import com.morgolt.education.patterns.creational.labyrinth.Maze;

@SuppressWarnings("EmptyMethod")
class MazeBuilder {

    // all methods are empty to allow ConcreteBuilders override only needed operations. MazeBuilder may be
    // interface or abstract class as well, depending on the task.
    void buildMaze() {}
    void buildRoom(int number) {}
    void buildDoor(int roomFrom, int roomTo) {}

    Maze getMaze() {
        return null;
    }
}
