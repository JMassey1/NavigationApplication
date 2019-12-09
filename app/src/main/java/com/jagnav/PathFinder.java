package com.jagnav;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

public class PathFinder {

    ArrayList<ArrayList<Location>> map;

    public PathFinder(ArrayList<ArrayList<Location>> map) {
        map = this.map;
    }

    public String[] findPath(Location start, Location end) {
        return new String[]{"test","test","test"};
    }

    public int[] getCoordinates(Location loc) throws LocationNotFound{
        for (int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.get(y).size(); x++) {
                if (map.get(x).get(y).equals(loc)) {
                    return new int[]{y,x};
                }
            }
        }
        throw new LocationNotFound("getting coords failed");
    }

    public int move(int[] initial, int[] end) throws LocationNotFound{
        int[] currentPos = initial;
        while (!(Arrays.equals(currentPos,end))) {

            Location upOne = map.get(currentPos[0]+1).get(currentPos[1]);
            Location rightOne = map.get(currentPos[0]).get(currentPos[1]+1);
            Location downOne = map.get(currentPos[0]-1).get(currentPos[1]);
            Location leftOne = map.get(currentPos[0]).get(currentPos[1]-1);

            assignHeuristic(upOne,end);
            assignHeuristic(rightOne,end);
            assignHeuristic(downOne,end);
            assignHeuristic(leftOne,end);




        }
        return 0;
    }

    public void assignHeuristic(Location loc, int[] endPos) throws LocationNotFound {



        if (!canMove(getCoordinates(loc))) {
            // Integer.MAX_VALUE;
        } else {
            int[] currentPos = getCoordinates(loc);
            loc.setHeuristic(Math.abs(currentPos[0] - endPos[0]) + Math.abs(currentPos[1] - endPos[1]));
        }


    }

    public boolean canMove(int[] endPos) {
        Location nextLoc = map.get(endPos[0]).get(endPos[1]);
        if (!(nextLoc instanceof VoidLocation)) {
            return true;
        }
        return false;
    }


}
