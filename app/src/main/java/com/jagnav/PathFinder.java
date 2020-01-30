package com.jagnav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PathFinder {

    ArrayList<ArrayList<Location>> map;

    public PathFinder(ArrayList<ArrayList<Location>> map) {
        this.map = map;
    }

    public int[] getCoordinates(Location loc) throws LocationNotFound{
        for (int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.get(y).size(); x++) {
                if (map.get(y).get(x).equals(loc)) {
                    return new int[]{y,x};
                }
            }
        }
        throw new LocationNotFound("getting coords failed");
    }

    public void move(Location start, Location dest) throws LocationNotFound{
        int[] initial = getCoordinates(start);
        int[] end = getCoordinates(dest);
        if (start.getFloor() != dest.getFloor()) {
            int[] finalEnd = end;
        }
        int[] currentPos = initial;

        ArrayList<Location> openNodes = new ArrayList<>();
        ArrayList<Location> closedNodes = new ArrayList<>();
        openNodes.add(start);

        while (!(Arrays.equals(currentPos, end))) {
            //find lowest fCost. Move it from opened to closed
            Collections.sort(openNodes);
            Location currentLoc = openNodes.remove(0);
            closedNodes.add(currentLoc);
            currentPos = getCoordinates(currentLoc);
            //System.out.println(currentPos[0] + ", " + currentPos[1]);

            //gets all locations surrounding current node
            Location upOne = map.get(currentPos[0] - 1).get(currentPos[1]);
            Location rightOne = map.get(currentPos[0]).get(currentPos[1] + 1);
            Location downOne = map.get(currentPos[0] + 1).get(currentPos[1]);
            Location leftOne = map.get(currentPos[0]).get(currentPos[1] - 1);

            //assigns heuristic values to each location
            assignHeuristic(upOne, initial, end);
            assignHeuristic(rightOne, initial, end);
            assignHeuristic(downOne, initial, end);
            assignHeuristic(leftOne, initial, end);

            //take all neighbor cells and put them in a list so a loop can be used to evaluate each
            ArrayList<Location> neighbors = new ArrayList<>();
            neighbors.add(upOne); // UP = 0
            neighbors.add(downOne); // DOWN = 1
            neighbors.add(rightOne); // RIGHT = 2
            neighbors.add(leftOne); // LEFT = 3


            for (Location neighbor: neighbors) {
                if (neighbor.getHeuristic() == Integer.MAX_VALUE || closedNodes.contains(neighbor)) {
                    continue;
                } else {
                    int newMovementCost = currentLoc.gCost + getDistance(currentLoc,neighbor);
                    if (newMovementCost < neighbor.gCost || !(openNodes.contains(neighbor))) {
                        neighbor.setGCost(newMovementCost);
                        neighbor.setHCost(getDistance(neighbor, dest));
                        neighbor.calculateFCost();
                        int[] neighborPos = getCoordinates(neighbor);
                        //System.out.println("NEIGHBOR COORDINATES");
                        //System.out.println("!!!!!" + neighborPos[0] + ", " + neighborPos[1]);
                        //System.out.println("SETTING PARENT LOC");
                        neighbor.setParentLoc(currentLoc);
                        if (!(openNodes.contains(neighbor))) {
                            openNodes.add(neighbor);
                        }
                    }

                }
            }
        }
        System.out.println("SUCCESS");
        ArrayList<Location> route = getRoute(start,dest);
        for (Location loc: route) {
            int[] locCoords = getCoordinates(loc);
            System.out.println(locCoords[0] + ", " + locCoords[1]);
        }

    }

    public ArrayList<Location> getRoute(Location start, Location end) throws LocationNotFound{

        ArrayList<Location> route = new ArrayList<>();
        Location currentLoc = end;
        int[] startPos = getCoordinates(start), endPos = getCoordinates(end);
        //System.out.println("START: " + startPos[0] + ", " + startPos[1]);
        //System.out.println("END:   " + endPos[0] + ", " + endPos[1]);

        while (!currentLoc.equals(start)) {
            //System.out.println("poop");
            Location parentLoc = currentLoc.getParentLoc();
            route.add(parentLoc);
            //System.out.println(parentLoc);
            currentLoc = parentLoc;
        }
        Collections.reverse(route);
        return route;
    }

    public void assignHeuristic(Location loc, int[] startPos, int[] endPos) throws LocationNotFound {

        int[] currentPos = getCoordinates(loc);

        if (canMove(loc)) {
            //Calculate G_Cost (Distance from current cell to start cell)
            loc.setGCost(Math.abs(currentPos[1] - startPos[1]) + Math.abs(currentPos[0] - startPos[0]));
            //Calculate H_Cost (Distance from end cell to current cell)
            loc.setHCost(Math.abs(endPos[1] - currentPos[1]) + Math.abs(endPos[0] - currentPos[0]));
            //Calculate F_Cost
            loc.calculateFCost();
        } else {
            loc.setHeuristic(Integer.MAX_VALUE);
        }




//        if (!canMove(loc)) {
//            loc.setHeuristic(Integer.MAX_VALUE);
//        } else {
//            int[] currentPos = getCoordinates(loc);
//            loc.setHeuristic(Math.abs(currentPos[0] - endPos[0]) + Math.abs(currentPos[1] - endPos[1]));
//        }


    }

    public boolean canMove(Location end) {
        Location nextLoc = end;
        if (!(nextLoc instanceof VoidLocation) || nextLoc instanceof RowTest) {
            return true;
        }
        return false;
    }

    public int getDistance(Location start, Location end) throws LocationNotFound{
        int[] startPos = getCoordinates(start), endPos = getCoordinates(end);
        return Math.abs(startPos[0] - endPos[0]) + Math.abs(startPos[1] - endPos[1]);
    }


}
