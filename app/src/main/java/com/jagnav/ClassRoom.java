package com.jagnav;

public class ClassRoom extends Location {
    private String roomNum,teacher,name;
    private int floor;

    public ClassRoom(int rn, String t, int f)
    {
        roomNum = Integer.toString(rn);
        teacher = t;
        floor = f;
    }

    public ClassRoom(String name, String teacher, int f) {
        this.name = name;
        this.teacher = teacher;
        floor = f;
    }

    public ClassRoom(String name, int f) {
        this.name = name;
        this.roomNum = name;
        floor = f;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public int getFloor() {
        return floor;
    }

    public String toString() {
        return "C";
    }

}
