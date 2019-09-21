package com.jagnav;

import com.opencsv.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Map {

    List<String[]> schoolMap;

    public Map() {

    }

    public void csvWrite(){
        System.out.println("Kylie is dumb");
    }


    /*
    public List<String[]> csvRead() throws IOException{
        List<String[]> list = new ArrayList<>();
        Reader reader1 = new FileReader("file.csv");
        CSVReader csvRead = new CSVReader(reader1);
        String[] line;
        while ((line = csvRead.readNext()) != null) {
            list.add(line);
        }
        reader1.close();
        csvRead.close();
        return list;

    }
    */

    public void csvRead() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("JagNavMap(INCOMPLETE_FOR_TESTING).csv"));
        schoolMap = reader.readAll();
    }

    public void printMap() {
        for (String[] x: schoolMap){
            for (String y: x){
                System.out.println(y);
            }
        }
    }
}
