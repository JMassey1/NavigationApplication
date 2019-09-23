package com.jagnav;

public class Intersection extends Room {
    int[] nearbyStairs;
    public Intersection(int[] ns, int f)
    {
        nearbyStairs = ns;
        floor = f;
    }
}
