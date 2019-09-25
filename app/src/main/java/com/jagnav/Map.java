package com.jagnav;

import com.opencsv.*;
import java.io.*;
import java.net.URISyntaxException;
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

    public void csvRead() {
        try {
            CSVReader reader = new CSVReader(new BufferedReader(new FileReader("JagNavMap.csv")));
            schoolMap = reader.readAll();
            System.out.println(schoolMap);
            System.out.println(new File("JagNavMap.csv"));
        }
        catch (FileNotFoundException e) {
                System.out.println("FILENOTFOUND");
        }
        catch (IOException e){
                System.out.println("IOEXCEPTION");
        }

        System.out.println("THIS METHOD ACTUALLY WORKS");

    }

    public void printMap() {
        /*for (String[] x: schoolMap){
            for (String y: x){
                System.out.println(y);
            }
        }*/
        System.out.println(schoolMap == null);
    }
}
