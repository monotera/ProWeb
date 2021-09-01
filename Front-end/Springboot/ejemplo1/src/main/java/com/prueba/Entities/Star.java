package com.prueba.Entities;

import java.util.ArrayList;

public class Star {
    private int x;
    private int y;
    private int z;
    private int id;
    ArrayList near_Stars = new ArrayList<>();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public ArrayList getNear_Stars() {
        return near_Stars;
    }

    public void setNear_Stars(ArrayList near_Stars) {
        this.near_Stars = near_Stars;
    }

    public Star(int x, int y, int z, int id) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
    }

}
