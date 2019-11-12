package com.jagnav;

public class Hall extends Location {
    int[] nearbyRooms;
    public Hall(int f)
    {
        floor = f;
    }

    public String toString(){
        return "H";
    }
}