package com.prueba.graph;

import java.util.Vector;

public class TestMain {
    public static void main(String[] args) {
        GalaxyGraphController graphController = new GalaxyGraphController();
        System.out.println("The generated random graph :");
        graphController.generateGalaxy();
        graphController.printGraph();
        /*
         * graphController.floydWarshall(); Vector<Integer> path; path =
         * graphController.constructPath(1, 3); graphController.printPath(path); path =
         * graphController.constructPath(0, 3); graphController.printPath(path); path =
         * graphController.constructPath(5, 3); graphController.printPath(path); path =
         * graphController.constructPath(8, 5); graphController.printPath(path);
         */
    }
}
