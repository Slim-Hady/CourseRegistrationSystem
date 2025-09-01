package Entits;

import Entits.Graph;
import java.util.*;

public class Toplogicalsort {

    public List<Integer> topologicalSort(Graph graph) {
        int V = graph.getVertices();
        Map<Integer, List<Integer>> adj = graph.getAdjList();
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (result.size() != V) {
            throw new RuntimeException("Cycle detected! No valid topological order.");
        }

        return result;
    }
}
