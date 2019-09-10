package com.jagnav;

public class ClassRoom extends Room {
    int roomNum;
    String teacher;
    public ClassRoom(int rn, String t)
    {
        roomNum = rn;
        teacher = t;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
