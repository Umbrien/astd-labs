package com.company.lab_4;

import java.util.LinkedList;


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
    LinkedList<Edge>[] adjacencyList;

    GraphWeighted(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEgde(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList[source].addLast(edge);
    }

    public void printGraph(){
        for (int i = 0; i < vertices; i++) {
            for (Edge edge : adjacencyList[i]) {
                System.out.println("vertex-" + edge.source + " is connected to vertex-" + edge.destination
                        + " with weight " + edge.weight);
            }
        }
    }
}