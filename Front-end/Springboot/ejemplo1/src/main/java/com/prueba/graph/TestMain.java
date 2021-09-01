package com.prueba.graph;

public class TestMain {
    public static void main(String[] args) {
        GalaxyGraphController graphController = new GalaxyGraphController();
        System.out.println("The generated random graph :");
        graphController.generateGalaxy();
        graphController.printGraph();
        graphController.BFS(0);
        System.out.println("asd");
        graphController.print_dfs();
    }
}
