package com.jagnav;

public class Stairs extends Location {
    int[] connectedFloors;
    int[][] linkedCoordinates;
    Location linkedLoc;
    public Stairs(int[][] ll) {
        linkedCoordinates = ll;
    }

    public Stairs() {

    }

    public Stairs(Location linkedLoc) {
        this.linkedLoc = linkedLoc;
    }

    public Location getLinkedLoc() {
        return linkedLoc;
    }
    public int[][] getLinkedCoordinates() {
        return linkedCoordinates;
    }

    public void setLinkedLoc(Stairs loc) {
        linkedLoc = loc;
    }

    public void setLinkedCoordinates(int[][] linkedCoordinates) {
        this.linkedCoordinates = linkedCoordinates;
    }

    public String toString(){
        return "S";
    }
}