package com.morgolt.education.patterns.creational.factorymethod;

import com.morgolt.education.patterns.creational.abstractfactory.enchanted.DoorNeedingSpell;
import com.morgolt.education.patterns.creational.abstractfactory.enchanted.EnchantedMazeFactory;
import com.morgolt.education.patterns.creational.abstractfactory.enchanted.EnchantedRoom;
import com.morgolt.education.patterns.creational.labyrinth.Door;
import com.morgolt.education.patterns.creational.labyrinth.Room;

public class EnchantedMazeGame extends MazeGame{

    @Override
    Room makeRoom(int n) {
        return new EnchantedRoom(n, castSpell());
    }

    @Override
    Door makeDoor(Room r1, Room r2) {
        return new DoorNeedingSpell(r1, r2);
    }

    private class Spell extends EnchantedMazeFactory.Spell {}

    private Spell castSpell() {
        return new Spell();
    }


}
