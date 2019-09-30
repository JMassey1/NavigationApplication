package com.jagnav;

import android.content.res.AssetManager;

import org.apache.commons.csv.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Map {

    List<String[]> schoolMap;

    public Map() {

    }

    public void csvWrite(){
        System.out.println("Kylie is dumb");
    }

    public void csvRead(AssetManager assetManager) {
        try {
            InputStream inputStream = assetManager.open("JagNavMap.csv", AssetManager.ACCESS_BUFFER);
            System.out.println("inputStream");
            Scanner scanner = new Scanner (new InputStreamReader(inputStream));
            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(counter++);
                String[] lineString = line.split(",");
                schoolMap.add(lineString);
//                for (String x: line.split(",")){
//                    System.out.println(x);
//                }

            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printMap() {
        for (String[] x: schoolMap){
            System.out.println(x);
        }
    }
}
