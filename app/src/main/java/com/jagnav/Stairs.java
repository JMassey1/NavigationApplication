package com.jagnav;

public class Stairs extends Location {
    int[] connectedFloors;
    String direction;
    public Stairs(int[] nr)
    {
        connectedFloors = nr;
    }

    public Stairs(int[] nr, String d)
    {
        connectedFloors = nr;
        direction = d;
    }
}