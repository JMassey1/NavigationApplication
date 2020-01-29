package com.jagnav;

public abstract class Location implements Comparable<Location> {
    int floor, heuristic, gCost, hCost, fCost;
    Location parentLoc;


    public String toString() {
        return "L";
    }
    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }
    public void setGCost(int g) {
        gCost = g;
    }
    public void setHCost(int h) {
        hCost = h;
    }
    public void setParentLoc(Location loc) {
        parentLoc = loc;
    }
    public void calculateFCost() {
        fCost = hCost + gCost;
    }
    public int getFloor() {
        return floor;
    }
    public int getHeuristic() {
        return heuristic;
    }

    public int getFCost() {
        return fCost;
    }
    public Location getParentLoc() {
        return parentLoc;
    }


    @Override
    public int compareTo(Location l) {
        return this.getFCost();
    }
}
