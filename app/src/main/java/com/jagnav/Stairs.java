package com.jagnav;

public class Stairs extends Location {
    int[] connectedFloors;
    Location linkedLoc;
    public Stairs(int[] nr)
    {
        connectedFloors = nr;
    }

    public Stairs() {

    }

    public Stairs(Location linkedLoc) {
        this.linkedLoc = linkedLoc;
    }

    public Location getLinkedLoc() {
        return linkedLoc;
    }


    public String toString(){
        return "S";
    }
}