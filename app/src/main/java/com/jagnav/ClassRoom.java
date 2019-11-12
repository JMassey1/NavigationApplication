package com.jagnav;

public class ClassRoom extends Location {
    String roomNum;
    String teacher;
    public ClassRoom(String rn, String t, int f)
    {
        roomNum = rn;
        teacher = t;
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
