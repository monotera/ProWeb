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

public class GalaxyGraphController {
    GalaxyGraph galaxy = new GalaxyGraph();
    ArrayList<Integer> aux = new ArrayList<>();
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

    public void clearGraph() {
        for (int i = 0; i < galaxy.getVertices(); i++)
            galaxy.getAdjacencyList().get(i).clear();
        galaxy.getAdjacencyList().clear();
    }

    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        ArrayList<Boolean> visited = new ArrayList<>(Arrays.asList(new Boolean[galaxy.getVertices()]));
        Collections.fill(visited, Boolean.FALSE);
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited.set(s, true);
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");
            aux.add(s);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = galaxy.getAdjacencyList().get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited.get(n)) {
                    visited.set(n, Boolean.TRUE);
                    queue.add(n);
                }
            }
        }
    }

    public void print_dfs() {
        Collections.sort(aux);
        for (int i = 0; i < aux.size(); i++) {
            System.out.print(aux.get(i) + " , ");
        }
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
