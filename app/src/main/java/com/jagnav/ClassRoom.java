package com.jagnav;

public class ClassRoom extends Location {
    String roomNum,teacher,name;
    int floor;
    public ClassRoom(int rn, String t, int f)
    {
        roomNum = Integer.toString(rn);
        teacher = t;
        floor = f;
    }

    public ClassRoom(String name, String teacher, int f) {
        name = this.name;
        teacher = this.teacher;
        floor = f;
    }

    public ClassRoom(String name, int f) {
        name = this.name;
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

    public String toString() {
        return "C";
    }
}
