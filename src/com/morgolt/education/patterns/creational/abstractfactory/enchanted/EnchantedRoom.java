package com.morgolt.education.patterns.creational.abstractfactory.enchanted;

import com.morgolt.education.patterns.creational.labyrinth.Room;

public class EnchantedRoom extends Room {

    private final EnchantedMazeFactory.Spell openSpell;

    public EnchantedRoom(int roomNumber, EnchantedMazeFactory.Spell spell) {
        super(roomNumber);
        this.openSpell = spell;
    }
}
