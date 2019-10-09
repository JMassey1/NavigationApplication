package com.jagnav;

import android.content.res.AssetManager;

import org.apache.commons.csv.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {

    List<String[]> schoolMap = new ArrayList<>();

    public Map() {

    }

    public void csvWrite(){
        System.out.println("Kylie is dumb");
    }

    public void csvRead(AssetManager assetManager) {
        try {
            InputStream inputStream = assetManager.open("JagNavMap.csv", AssetManager.ACCESS_BUFFER);
            Scanner scanner = new Scanner (new InputStreamReader(inputStream));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                schoolMap.add(line.split(","));


            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printMap() {
        for (String[] array : schoolMap) {
            for (String s : array) {
                String line = (s + ",").trim();
                System.out.print(line);
            }
            System.out.println();
        }
    }
}
