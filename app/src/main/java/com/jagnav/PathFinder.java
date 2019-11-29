package com.jagnav;
import java.util.ArrayList;

public abstract class PathFinder {

    public static String[] findPath(ArrayList<ArrayList<Location>> map, Location start, Location end) {
        return new String[]{"test","test","test"};
    }

    public static int[] getCoordinates(ArrayList<ArrayList<Location>> map, Location loc) throws LocationNotFound{
        for (int x = 0; x < map.size(); x++) {
            for (int y = 0; y < map.get(0).size(); y++) {
                if (map.get(x).get(y).equals(loc)) {
                    return new int[]{x,y};
                }
            }
        }
        throw new LocationNotFound("getting coords failed");
    }

    public static Object[] move(int[] initial, int[] movement, int count) {

       // for (int x = initial[0]; x <)




        return new Object[]{};
    }

    public static boolean canMove(int[] initialPos, int[] endPos) {

        return true;
    }


}
