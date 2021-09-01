package com.prueba.graph;

public class TestMain {
    public static void main(String[] args) {
        GalaxyGraphController graphController = new GalaxyGraphController();
        System.out.println("The generated random graph :");
        graphController.generateGalaxy();
        graphController.printGraph();
        graphController.printShortestDistance(0, 5000);
    }
}
