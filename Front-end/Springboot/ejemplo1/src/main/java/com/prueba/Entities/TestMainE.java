package com.prueba.Entities;

import java.util.ArrayList;

public class TestMainE {
    public static void main(String[] args) {
        ArrayList<Star> s = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            s.add(new Star(i, i, i, i));
        }
        StarController sc = new StarController(s);

    }
}
