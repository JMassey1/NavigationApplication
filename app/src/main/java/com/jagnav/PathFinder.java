package com.jagnav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PathFinder {

    ArrayList<ArrayList<Location>> map;
    Map schoolMap;

    public PathFinder(Map schoolMap) {
        this.schoolMap = schoolMap;
        map = schoolMap.getSchoolMap();
    }


    public ArrayList<Location> findPath(Location start, Location dest) throws LocationNotFound{
        try {
            ArrayList<Location> route = move(start,dest, true);
            for (Location loc: route) {
                int[] locCoords = schoolMap.getCoordinates(loc);
                System.out.println(locCoords[0] + ", " + locCoords[1]);
            }
            return route;
        } catch (MismatchFloor m) {
            try {

                Stairs end = (Stairs)schoolMap.findNearestStairs(start);
                int[] firstEndPos = schoolMap.getCoordinates(end);
                System.out.println("[" + firstEndPos[0] + "," + firstEndPos[1] + "]");

                ArrayList<Location> route;
                route = move(start, end, false);
                route.addAll(move(end.getLinkedLoc(), dest,false));
                for (Location loc: route) {
                    int[] locCoords = schoolMap.getCoordinates(loc);
                    System.out.println(locCoords[0] + ", " + locCoords[1]);
                }
                return route;
            } catch (MismatchFloor m1) {
                m1.printStackTrace();
            }
        }
        schoolMap.resetParents();
        return null;
    }


    public ArrayList<Location> move(Location start, Location dest, Boolean firstRun) throws LocationNotFound, MismatchFloor{
        if (firstRun && start.getFloor() != dest.getFloor()) {
            throw new MismatchFloor("Locations are on separate floors");
        }
        int[] initial = schoolMap.getCoordinates(start);
        int[] end = schoolMap.getCoordinates(dest);

        int[] currentPos = initial;

        ArrayList<Location> openNodes = new ArrayList<>();
        ArrayList<Location> closedNodes = new ArrayList<>();
        openNodes.add(start);
        while (!(Arrays.equals(currentPos, end))) {
            //find lowest fCost. Move it from opened to closed
            Collections.sort(openNodes);
            Location currentLoc = openNodes.remove(0);
            closedNodes.add(currentLoc);
            currentPos = schoolMap.getCoordinates(currentLoc);
            //System.out.println(currentPos[0] + ", " + currentPos[1]);

            //gets all locations surrounding current node
            //System.out.println("currentPos: " + currentPos[0]+","+currentPos[1]);
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
                        int[] neighborPos = schoolMap.getCoordinates(neighbor);
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

        return route;

    }
    //returns an array of Locations in order from start to finish
    public ArrayList<Location> getRoute(Location start, Location end) throws LocationNotFound{
        ArrayList<Location> route = new ArrayList<>();
        Location currentLoc = end;
        route.add(end);
        while (!currentLoc.equals(start)) {
            Location parentLoc = currentLoc.getParentLoc();
            route.add(parentLoc);
            currentLoc = parentLoc;
        }
        Collections.reverse(route);
        return route;
    }

    public void assignHeuristic(Location loc, int[] startPos, int[] endPos) throws LocationNotFound {
        int[] currentPos = schoolMap.getCoordinates(loc);

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


    }

    public boolean canMove(Location end) {
        Location nextLoc = end;
        if (!(nextLoc instanceof VoidLocation) || nextLoc instanceof RowTest) {
            return true;
        }
        return false;
    }

    public int getDistance(Location start, Location end) throws LocationNotFound{
        int[] startPos = schoolMap.getCoordinates(start), endPos = schoolMap.getCoordinates(end);
        return Math.abs(startPos[0] - endPos[0]) + Math.abs(startPos[1] - endPos[1]);
    }


}
