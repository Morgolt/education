package com.morgolt.education.factorymethod;

import com.morgolt.education.abstractfactory.enchanted.DoorNeedingSpell;
import com.morgolt.education.abstractfactory.enchanted.EnchantedMazeFactory;
import com.morgolt.education.abstractfactory.enchanted.EnchantedRoom;
import com.morgolt.education.labyrinth.Door;
import com.morgolt.education.labyrinth.Room;

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
