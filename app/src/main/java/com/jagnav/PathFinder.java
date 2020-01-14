package com.jagnav;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

public class PathFinder {

    ArrayList<ArrayList<Location>> map;

    public PathFinder(ArrayList<ArrayList<Location>> map) {
        this.map = map;
    }

    public String[] findPath(Location start, Location end) {
        return new String[]{"test","test","test"};
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
        Map finder = new Map();
        int[] initial = getCoordinates(start);
        int[] end = getCoordinates(dest);
        if (start.getFloor() != dest.getFloor()) {

        }
        int[] currentPos = initial;
        while (!(Arrays.equals(currentPos, end))) {

            Location upOne = map.get(currentPos[0] - 1).get(currentPos[1]);
            Location rightOne = map.get(currentPos[0]).get(currentPos[1] + 1);
            Location downOne = map.get(currentPos[0] + 1).get(currentPos[1]);
            Location leftOne = map.get(currentPos[0]).get(currentPos[1] - 1);

            assignHeuristic(upOne, end);
            assignHeuristic(rightOne, end);
            assignHeuristic(downOne, end);
            assignHeuristic(leftOne, end);

            Location temp;
            if (Math.abs(currentPos[0] - end[0]) < Math.abs(currentPos[1] - end[1])) {
                temp = leftOne;
                if (rightOne.getHeuristic() < temp.getHeuristic()) {
                    temp = rightOne;
                }
                if (downOne.getHeuristic() < temp.getHeuristic()) {
                    temp = downOne;
                }
                if (upOne.getHeuristic() < temp.getHeuristic()) {
                    temp = upOne;
                }
            }
            else {
                temp = upOne;
                if (downOne.getHeuristic() < temp.getHeuristic()) {
                    temp = downOne;
                }
                if (rightOne.getHeuristic() < temp.getHeuristic()) {
                    temp = rightOne;
                }
                if (leftOne.getHeuristic() < temp.getHeuristic()) {
                    temp = leftOne;
                }

            }

            currentPos = getCoordinates(temp);


            System.out.println(currentPos[0] + ", " + currentPos[1]);
            System.out.println(temp.getHeuristic());
        }
    }

    public void assignHeuristic(Location loc, int[] endPos) throws LocationNotFound {



        if (!canMove(getCoordinates(loc))) {
            loc.setHeuristic(Integer.MAX_VALUE);
        } else {
            int[] currentPos = getCoordinates(loc);
            loc.setHeuristic(Math.abs(currentPos[0] - endPos[0]) + Math.abs(currentPos[1] - endPos[1]));
        }


    }

    public boolean canMove(int[] endPos) {
        Location nextLoc = map.get(endPos[0]).get(endPos[1]);
        if (!(nextLoc instanceof VoidLocation) || !(nextLoc instanceof RowTest)) {
            return true;
        }
        return false;
    }


}
