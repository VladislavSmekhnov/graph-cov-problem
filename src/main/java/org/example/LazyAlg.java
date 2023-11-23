package org.example;

public class LazyAlg {
    private int[][] graph;
    int len;

    public LazyAlg(int[][] graph) {
        this.graph = graph;
        len = graph.length;
    }

    // Chose first vertex, connected to this one
    // if no edges found returns -1
    private int chooseFirstEdge(int k) {
        for (int i = 1; i < len; i++) {
            if (graph[i][k] == 1) {
                return i;
            }
        }

        return -1;
    }

    private void RemoveIncident(int i, int j) {
        for(int k = 0; k < len; k++) {
            graph[i][k] = 0;
            graph[k][i] = 0;
            graph[j][k] = 0;
            graph[k][j] = 0;
        }
    }
}
