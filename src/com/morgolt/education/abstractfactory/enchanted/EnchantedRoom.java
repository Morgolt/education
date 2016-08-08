package com.morgolt.education.abstractfactory.enchanted;

import com.morgolt.education.labyrinth.Room;

public class EnchantedRoom extends Room {

    private final EnchantedMazeFactory.Spell openSpell;

    public EnchantedRoom(int roomNumber, EnchantedMazeFactory.Spell spell) {
        super(roomNumber);
        this.openSpell = spell;
    }
}
