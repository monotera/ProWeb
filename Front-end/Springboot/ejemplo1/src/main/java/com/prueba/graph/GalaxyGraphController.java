package com.prueba.graph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class GalaxyGraphController {
    GalaxyGraph galaxy = new GalaxyGraph();

    Random random = new Random();

    public void generateGalaxy() {
        int c = random.nextInt(galaxy.getVertices());
        for (int i = 0; i < galaxy.getVertices(); i++) {
            if (c != i)
                addEdge(c, i);
        }

        for (int i = 0; i < galaxy.getEdges(); i++) {

            int v = random.nextInt(galaxy.getVertices());
            int w = random.nextInt(galaxy.getVertices());
            if ((v == w) || galaxy.getAdjacencyList().get(v).contains(w)) {
                i = i - 1;
                continue;
            }
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        galaxy.getAdjacencyList().get(v).add(w);
        if (v != w)
            galaxy.getAdjacencyList().get(w).add(v);
    }

    public void printGraph() {
        try {
            FileWriter myWriter = new FileWriter("graph.txt");
            System.out.println("Successfully wrote to the file.");
            for (int i = 0; i < galaxy.getAdjacencyList().size(); i++) {
                String aux = Integer.toString(i) + "-> {";
                myWriter.write(aux);

                List<Integer> list = galaxy.getAdjacencyList().get(i);

                if (list.isEmpty())
                    myWriter.write("No adjacent vertices");

                else {
                    int size = list.size();
                    for (int j = 0; j < size; j++) {
                        aux = Integer.toString(list.get(j));
                        myWriter.write(aux);
                        if (j < size - 1)
                            myWriter.write(" , ");
                    }
                }
                myWriter.write("}\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
