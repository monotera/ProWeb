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

        /*
         * int c = random.nextInt(galaxy.getVertices()); for (int i = 0; i <
         * galaxy.getVertices(); i++) { if (c != i) addEdge(c, i); }
         */

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

    public boolean BFS(int src, int dest, ArrayList<Integer> pred, ArrayList<Integer> dist) {

        LinkedList<Integer> queue = new LinkedList<Integer>();

        ArrayList<Boolean> visited = new ArrayList<>(Arrays.asList(new Boolean[galaxy.getVertices()]));
        Collections.fill(visited, Boolean.FALSE);

        visited.set(src, Boolean.TRUE);
        dist.set(src, 0);
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < galaxy.getAdjacencyList().get(u).size(); i++) {
                if (visited.get(galaxy.getAdjacencyList().get(u).get(i)) == false) {
                    visited.set(galaxy.getAdjacencyList().get(u).get(i), Boolean.TRUE);
                    dist.set(galaxy.getAdjacencyList().get(u).get(i), dist.get(u) + 1);
                    pred.set(galaxy.getAdjacencyList().get(u).get(i), u);
                    queue.add(galaxy.getAdjacencyList().get(u).get(i));

                    if (galaxy.getAdjacencyList().get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }

    // function to print the shortest distance and path
    // between source vertex and destination vertex
    public void printShortestDistance(int s, int dest) {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        ArrayList<Integer> pred = new ArrayList<>(Collections.nCopies(galaxy.getVertices(), -1));
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(galaxy.getVertices(), Integer.MAX_VALUE));

        if (BFS(s, dest, pred, dist) == false) {
            System.out.println("Given source and destination" + "are not connected");
            return;
        }

        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred.get(crawl) != -1) {
            path.add(pred.get(crawl));
            crawl = pred.get(crawl);
        }

        // Print distance
        System.out.println("Shortest path length is: " + dist.get(dest));

        // Print path
        System.out.println("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
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
