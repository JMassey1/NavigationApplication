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
        for (int x = 0; x < map.size(); x++) {
            for (int y = 0; y < map.get(0).size(); y++) {
                if (map.get(x).get(y).equals(loc)) {
                    return new int[]{x,y};
                }
            }
        }
        throw new LocationNotFound("getting coords failed");
    }

    //Idea is this method will return the number of times you can move in that direction (towards the endPos) until you encounter an unmoveable tile
    public int move(int[] initial, int[] movement, int count) {

       // for (int x = initial[0]; x <)




        return 0;
    }

    public boolean canMove(int[] endPos) {
        Location nextLoc = map.get(endPos[0]).get(endPos[1]);
        if (!(nextLoc instanceof VoidLocation)) {
            return true;
        }
        return false;
    }


}
