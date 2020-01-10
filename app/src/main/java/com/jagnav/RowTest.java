package com.jagnav;

import com.jagnav.Location;

public class RowTest extends Location {
    int rowNum;
    public RowTest(int rowNum) {
        this.rowNum = rowNum;
    }
    public String toString() {
        return Integer.toString(rowNum);
    }
}