package Entits;

import java.util.*;

public class Graph {
    private int vertices;
    private Map<Integer, List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
    }
    public int getVertices() {
        return vertices;
    }

    public Map<Integer, List<Integer>> getAdjList() {
        return adjList;
    }
}
