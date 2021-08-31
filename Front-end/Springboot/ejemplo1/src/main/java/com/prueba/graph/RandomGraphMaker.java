package com.prueba.graph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGraphMaker {
    public int vertices;
    public int edges;

    final int MAX_EDGES = 4000;
    final int MAX_VERTICES = 40000;

    Random random = new Random();

    public List<List<Integer>> adjacencyList;

    public RandomGraphMaker() {
        this.vertices = MAX_VERTICES;

        this.edges = random.nextInt(computeMaxEdges(MAX_EDGES)) + 1;
 
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++)
            adjacencyList.add(new ArrayList<>());

        for (int i = 0; i < edges; i++) {

            int v = random.nextInt(vertices);
            int w = random.nextInt(vertices);

            if ((v == w) || adjacencyList.get(v).contains(w)) {
                i = i - 1;
                continue;
            }
            addEdge(v, w);
        }
    }

    int computeMaxEdges(int numOfVertices) {
        return numOfVertices * ((numOfVertices - 1) / 2);
    }

    void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
        if (v != w)
            adjacencyList.get(w).add(v);
    }

    public static void main(String[] args) {
        RandomGraphMaker randomGraph = new RandomGraphMaker();
        System.out.println("The generated random graph :");
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            System.out.println("Successfully wrote to the file.");
            for (int i = 0; i < randomGraph.adjacencyList.size(); i++) {
                String aux = Integer.toString(i) + "-> {";
                myWriter.write(aux);

                List<Integer> list = randomGraph.adjacencyList.get(i);

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
