package com.jagnav;
import java.util.ArrayList;

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

    public int move(int[] initial, int[] movement, int count) {

       // for (int x = initial[0]; x <)




        return 0;
    }

    public void assignHeuristic(Location end) throws LocationNotFound {
        int[] endPos = getCoordinates(end);

        for (int y = 0; y < map.size() - 1; y++) {
            for (int x = 0; x < map.get(0).size() - 1; x++){
                Location loc = map.get(y).get(x);
                int[] currentPos = getCoordinates(loc);
                loc.setHeurisitc(Math.abs(current))
            }
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
