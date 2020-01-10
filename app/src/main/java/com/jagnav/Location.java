package com.jagnav;

public abstract class Location {
    int floor;
    int heuristic;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String toString() {        return "L"; }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }
    public int getHeuristic()
    {
        return heuristic;
    }

}
