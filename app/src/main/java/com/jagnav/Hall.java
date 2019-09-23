package com.jagnav;

public class Hall extends Room {
    int[] nearbyRooms;
    public Hall(int[] nr, int f)
    {
        int[] nearbyRooms = nr;
        floor = f;
    }
}