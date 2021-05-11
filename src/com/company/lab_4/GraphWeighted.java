package com.company.lab_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class GraphWeighted {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    int vertices;
    ArrayList<Edge> edgesList = new ArrayList<>();
    int[][] adjacencyMatrix;

    GraphWeighted(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEgde(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        edgesList.add(edge);

        adjacencyMatrix[source][destination]=weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public void kruskalMST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(edgesList.size(), Comparator.comparingInt(o -> o.weight));
        pq.addAll(edgesList);

        int[] parent = new int[vertices];
        makeSet(parent);
        ArrayList<Edge> mst = new ArrayList<>();
        int index = 0;

        while(index < vertices-1){
            Edge edge = pq.remove();

            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);

            if(x_set != y_set){
                mst.add(edge);
                index++;
                union(parent,x_set,y_set);
            }
        }

        printMST(mst);
    }

    public void makeSet(int[] parent) {
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
    }

    public int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        return vertex;
    }

    public void union(int [] parent, int x, int y){
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);

        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }

    public void printGraph() {
        for (Edge edge : edgesList) {
            System.out.println("Source: " + edge.source +
                    " destination: " + edge.destination +
                    " weight: " + edge.weight);
        }
}

    public void printMST(ArrayList<Edge> edgeList) {
        System.out.println("Kruskal Algorithm: (Minimum Spanning Tree)");
        for (Edge edge : edgeList) {
            System.out.println("Source: " + edge.source +
                    " destination: " + edge.destination +
                    " weight: " + edge.weight);
        }
    }

    int getMinimumVertex(boolean[] mst, int[] key) {
        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < vertices; i++) {
            if(!mst[i] && minKey > key[i]){
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public void dijkstra_GetMinDistances(int sourceVertex) {
        boolean[] spt = new boolean[vertices];
        int [] distance = new int[vertices];
        int INFINITY = Integer.MAX_VALUE;

        for (int i = 0; i < vertices; i++) {
            distance[i] = INFINITY;
        }

        distance[sourceVertex] = 0;

        for (int i = 0; i < vertices; i++) {
            int vertex_U = getMinimumVertex(spt, distance);
            spt[vertex_U] = true;

            for (int vertex_V = 0; vertex_V < vertices; vertex_V++) {
                if (adjacencyMatrix[vertex_U][vertex_V]>0) {
                    if (!spt[vertex_V] && adjacencyMatrix[vertex_U][vertex_V] != INFINITY) {
                        int newKey = adjacencyMatrix[vertex_U][vertex_V] + distance[vertex_U];

                        if (newKey < distance[vertex_V])
                            distance[vertex_V] = newKey;
                    }
                }
            }
        }
        printDijkstra(sourceVertex, distance);
    }

    public void printDijkstra(int sourceVertex, int[] key) {
        System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Source Vertex: " + sourceVertex + " to vertex " + i + " distance: " + key[i]);
        }
    }
}