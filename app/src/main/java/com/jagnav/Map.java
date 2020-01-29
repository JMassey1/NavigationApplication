package com.jagnav;

import android.content.res.AssetManager;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Map {

    List<String[]> schoolMap = new ArrayList<>();
    ArrayList<ArrayList<Location>> schoolMap2 = new ArrayList<ArrayList<Location>>();

    public Map() {

    }

    public Location findLocation(String roomNum) {
        for (int y = 0; y < schoolMap2.size(); y++) {
            for (int x = 0; x < schoolMap2.get(y).size(); x++) {
                try {
                    ClassRoom temp = (ClassRoom) schoolMap2.get(y).get(x);
                    //System.out.println("!!!!" + temp.getRoomNum());
                    if (temp instanceof ClassRoom && temp.getRoomNum() != null) {
                        if ((temp).getRoomNum().equals(roomNum)) {
                            return temp;
                        }
                    }
                } catch (ClassCastException c) {

                }
            }
        }
        return new VoidLocation();
    }

    public ArrayList<ArrayList<Location>> getSchoolMap() {
        return schoolMap2;
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
       // System.out.println("--00000000000000000000000000000L");
        for (List<Location> row : schoolMap2) {
            for (Location loc: row) {
                System.out.print(loc);
            }
            System.out.println();
        }
        //System.out.println("TEST");
//        for (Location loc: schoolMap2.get(0)) {
//            System.out.print(loc);
//        }
//        System.out.println();
    }

    public void populateMap(){

//        for (String i: schoolMap.get(0)) {
//            System.out.println(i);
//        }
        for (int x = 0; x < Integer.parseInt(schoolMap.get(schoolMap.size() - 1)[0]); x++) {
            ArrayList<Location> newRow = new ArrayList<>();
            if (x < 38) {
                RowTest testNum = new RowTest(x);
                newRow.add(testNum);
            }
            for (String[] cell: schoolMap) {

                if (cell[1].matches(Integer.toString(x))) {

                    try {
                        if (Integer.parseInt(cell[3]) > 0 | cell[3].contains("/")) {
                            newRow.add(new ClassRoom(Integer.parseInt(cell[3]), cell[4], Integer.parseInt(cell[2])));
                        } else {

                        }
                    } catch (NumberFormatException e) {
                        if (cell[3].contains("null")) {
                            newRow.add(new VoidLocation());
                        } else if (cell[3].contains("Stairs")) {
                            newRow.add(new Stairs());
                        } else if (cell[3].contains("Hall")) {
                            newRow.add(new Hall(1));
                        } else if (cell[3].contains("Exit")) {
                            newRow.add(new Exit());
                        } else {
                            newRow.add(new ClassRoom(cell[3].toLowerCase(), Integer.parseInt(cell[2])));
                        }
                    } catch (ArrayIndexOutOfBoundsException e1) {
                        newRow.add(new ClassRoom(cell[3], "N/A", 1));
                    }
                }
            }
            schoolMap2.add(newRow);
        }


    }


}
