package com.morgolt.education.labyrinth;

public class Wall extends MapSite implements Cloneable{

    @Override
    public void enter() {
    }


    @Override
    public Wall clone() {
        try {
            return (Wall)super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
