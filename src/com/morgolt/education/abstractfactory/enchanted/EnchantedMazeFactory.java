package com.morgolt.education.abstractfactory.enchanted;

import com.morgolt.education.abstractfactory.MazeFactory;
import com.morgolt.education.labyrinth.Door;
import com.morgolt.education.labyrinth.Room;

public class EnchantedMazeFactory extends MazeFactory {

    @Override
    public Room makeRoom(int number) {
        return new EnchantedRoom(number, castSpell());
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new DoorNeedingSpell(r1, r2);
    }

    public Spell castSpell() {
        return new Spell();
    }

    public static class Spell {
    }
}
