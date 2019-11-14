package com.jagnav;

import android.content.res.AssetManager;

import org.apache.commons.csv.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Map {

    List<String[]> schoolMap = new ArrayList<>();
    List<ArrayList<Location>> schoolMap2 = new ArrayList<ArrayList<Location>>();

    public Map() {

    }

    public void csvWrite(){
        System.out.println("Kylie is dumb");
    }

    public void csvRead(AssetManager assetManager) {
        try {
            InputStream inputStream = assetManager.open("JagNavMap.csv", AssetManager.ACCESS_BUFFER);
            Scanner scanner = new Scanner(new InputStreamReader(inputStream));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                schoolMap.add(line.split(","));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMap() {
        for (List<Location> col : schoolMap2) {
            for (Location loc: col) {
                System.out.print(loc);
            }
            System.out.println();
        }
    }

    public void populateMap(){

        //System.out.println(schoolMap.get(schoolMap.size() - 1));

        for (int x = 0; x < Integer.parseInt(schoolMap.get(schoolMap.size() - 1)[0]); x++) {

            for (String[] cell: schoolMap) {


                if (cell[3].matches("[0-9]")) {
                    newRow.add(new ClassRoom(cell[3], cell[4], 1));
                } else if (cell[3].contains("Library")) {
                    newRow.add(new Location());
                } else if (cell[3].contains("Intersection")) {
                    newRow.add(new Intersection(1));
                } else if (cell[3].contains("Hall")) {
                    newRow.add(new Hall(1));
                } else if (cell[3].contains("null")) {
                    newRow.add(new Location());
                }

                schoolMap2.add(newRow);
            }
        }


    }


}
