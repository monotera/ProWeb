package com.prueba.graph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class GalaxyGraphController {
    GalaxyGraph galaxy = new GalaxyGraph();
    ArrayList<Integer> aux = new ArrayList<>();
    Random random = new Random();
    final static int INF = 99999;
    ArrayList<ArrayList<Integer>> dist;
    ArrayList<ArrayList<Integer>> next;

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
        galaxy.getAdjacencyList().get(v).set(w, 1);
        if (v != w)
            galaxy.getAdjacencyList().get(w).set(v, 1);
    }

    public void clearGraph() {
        for (int i = 0; i < galaxy.getVertices(); i++)
            galaxy.getAdjacencyList().get(i).clear();
        galaxy.getAdjacencyList().clear();
    }

    public void floydWarshall() {
        int i, j, k;
        dist = new ArrayList<>(galaxy.getVertices());
        next = new ArrayList<>(galaxy.getVertices());
        for (i = 0; i < galaxy.getVertices(); i++) {
            dist.add(new ArrayList<>(galaxy.getAdjacencyList().get(i)));
            next.add(new ArrayList<>(galaxy.getAdjacencyList().get(i)));
        }
        for (i = 0; i < galaxy.getVertices(); i++)
            for (j = 0; j < galaxy.getVertices(); j++) {
                if (galaxy.getAdjacencyList().get(i).get(j) == INF)
                    next.get(i).set(j, -1);
                else
                    next.get(i).set(j, j);
            }

        for (k = 0; k < galaxy.getVertices(); k++) {
            for (i = 0; i < galaxy.getVertices(); i++) {
                for (j = 0; j < galaxy.getVertices(); j++) {
                    if (dist.get(i).get(k) == INF || dist.get(k).get(j) == INF)
                        continue;
                    if (dist.get(i).get(k) + dist.get(k).get(j) < dist.get(i).get(j)) {
                        dist.get(i).set(j, dist.get(i).get(j) + dist.get(k).get(j));
                        next.get(i).set(j, next.get(i).get(k));
                    }
                }
            }
        }
    }

    // Function construct the shortest
    // path between u and v
    public Vector<Integer> constructPath(int u, int v) {

        // If there's no path between
        // node u and v, simply return
        // an empty array
        if (next.get(u).get(v) == -1)
            return null;

        // Storing the path in a vector
        Vector<Integer> path = new Vector<Integer>();
        path.add(u);

        while (u != v) {
            u = next.get(u).get(v);
            path.add(u);
        }
        return path;
    }

    public void printPath(Vector<Integer> path) {
        int n = path.size();
        for (int i = 0; i < n - 1; i++)
            System.out.print(path.get(i) + " -> ");
        System.out.print(path.get(n - 1) + "\n");
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
                        if (list.get(j) != INF) {
                            aux = Integer.toString(j);
                            myWriter.write(aux);
                        }
                        if (j < size - 1 && list.get(j) != INF)
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
