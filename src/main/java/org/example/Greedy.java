package org.example;

import java.util.ArrayList;
import java.util.List;

public class Greedy {

    //���������� ������ ������� � ���������� ��������
    private static int getMaxDeg(int[] vertex) {
        int I = 0;
        int max = 0;

        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] > max) {
                max = vertex[i];
                I = i;
            }
        }

        return I;
    }

    //������ �������� � ������� �������� � ������
    private static int[] countVertexDegs(int[][] graph) {
        int n = graph.length;
        int[] vertex_deg = new int[n];

        for(int i = 0; i < n; i++) {
            vertex_deg[i] = 0;

            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 1) {
                    vertex_deg[i]++;
                    if(i == j) vertex_deg[i]++;
                }
            }
        }

        return vertex_deg;
    }

    //� ����� ��� ���� ��� ���?
    public static boolean isEmpty(int[] vertex) {
        for(int i = 0; i < vertex.length; i++) {
            if (vertex[i] != 0) {
                return false;
            }
        }

        return true;
    }

    //�������
    public static List<Integer> solve(int[][] igraph) {
        var graph = (int[][]) igraph.clone();
        List<Integer> result = new ArrayList<>();

        int n = graph.length;

        int[] vertex_deg = countVertexDegs(graph);

        int vertex;

        for(; result.size() < n && !isEmpty(vertex_deg);) {
            //����� ����� ������� � ���������� ��������
            vertex = getMaxDeg(vertex_deg);
            result.add(vertex);

            //������� ��� ������� �� ����� � �� ������� ��������
            for(int i = 0; i < n; i++) {
                graph[vertex][i] = graph[i][vertex] = 0;
            }

            vertex_deg = countVertexDegs(graph);
        }

        return result;
    }
}
