package com.jagnav;

import org.apache.commons.csv.*;
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
            CSVParser parser = CSVParser.parse((new FileReader("JagNavMap.csv")), CSVFormat.DEFAULT);
            for (CSVRecord record : parser)
            {
                System.out.println(record);
            }
        }
        catch (FileNotFoundException e) {
                System.out.println("FILENOTFOUND");
        }
        catch (IOException e){
                System.out.println("IOEXCEPTION");
        }

        System.out.println("THIS METHOD ACTUALLY WORKS");

    }
}
