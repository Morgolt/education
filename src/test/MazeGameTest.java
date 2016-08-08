package test;

import com.morgolt.education.abstractfactory.MazeFactory;
import com.morgolt.education.builder.StandardMazeBuilder;
import com.morgolt.education.labyrinth.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class MazeGameTest {

    Maze expectedMaze;
    @BeforeClass
    public void setUp() throws Exception {
        // basic maze with 2 rooms and a door
        expectedMaze = new Maze();
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Door theDoor = new Door(r1, r2);

        r1.setSide(Direction.North, new Wall());
        r1.setSide(Direction.East, theDoor);
        r1.setSide(Direction.South, new Wall());
        r1.setSide(Direction.West, new Wall());

        r2.setSide(Direction.North, new Wall());
        r2.setSide(Direction.East, new Wall());
        r2.setSide(Direction.South, new Wall());
        r2.setSide(Direction.West, theDoor);

        expectedMaze.addRoom(r1);
        expectedMaze.addRoom(r2);
    }

    @Test
    public void testCreateMazeUsingSet() throws Exception {
        Maze testMaze = new MazeGame().createMaze();
        assertEquals(expectedMaze, testMaze);
    }

    @Test
    public void testCreateMazeUsingFactory() throws Exception {
        MazeFactory factory = new MazeFactory();
        Maze testMaze = new com.morgolt.education.abstractfactory.MazeGame().createMaze(factory);
        assertEquals(expectedMaze, testMaze);
    }

    @Test
    public void testCreateMazeUsingStandartBuilder() throws Exception {
        StandardMazeBuilder builder = new StandardMazeBuilder();
        Maze testMaze = new com.morgolt.education.builder.MazeGame().createMaze(builder);
        assertEquals(expectedMaze, testMaze);
    }

    @Test
    public void testCreateMazeUsingFactoryMethods() throws Exception {
        Maze testMaze = new com.morgolt.education.factorymethod.MazeGame().createMaze();
        assertEquals(expectedMaze, testMaze);
    }

}