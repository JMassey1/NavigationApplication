package com.jagnav;

public class Intersection extends Location {
    int[] nearbyStairs;
    public Intersection(int f)
    {
        floor = f;
    }

    public String toString() {
        return "I";
    }
}
