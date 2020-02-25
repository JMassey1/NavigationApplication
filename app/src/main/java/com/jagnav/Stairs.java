package com.jagnav;

public class Stairs extends Location {
    int[] linkedCoordinates;
    Location linkedLoc;
    public Stairs(int[] ll) {
        linkedCoordinates = ll;
    }

    public Location getLinkedLoc() {
        return linkedLoc;
    }
    public int[] getLinkedCoordinates() {
        return linkedCoordinates;
    }

    public void setLinkedLoc(Stairs loc) {
        linkedLoc = loc;
    }

    public String toString(){
        return "S";
    }
}