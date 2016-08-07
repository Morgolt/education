package com.morgolt.education.abstractfactory.enchanted;

import com.morgolt.education.labyrinth.Room;

class EnchantedRoom extends Room {

    private EnchantedMazeFactory.Spell openSpell;

    EnchantedRoom(int roomNumber, EnchantedMazeFactory.Spell spell) {
        super(roomNumber);
        this.openSpell = spell;
    }
}
