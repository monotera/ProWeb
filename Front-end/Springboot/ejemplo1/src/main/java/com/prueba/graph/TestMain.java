package com.prueba.graph;

import java.io.FileWriter;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        GalaxyGraphController graphController = new GalaxyGraphController();
        System.out.println("The generated random graph :");
        graphController.generateGalaxy();
        graphController.printGraph();

    }
}
