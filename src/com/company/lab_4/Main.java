package com.company.lab_4;


public class Main {
    public static void main(String[] args) {
        int vertices = 6;
        int sourceVertex = 0;
        GraphWeighted graph = new GraphWeighted(vertices);

        graph.addEgde(0,3,5);
        graph.addEgde(0,2,1);
        graph.addEgde(0,1,6);
        graph.addEgde(1,2,5);
        graph.addEgde(1,4,3);
        graph.addEgde(3,2,5);
        graph.addEgde(2,4,6);
        graph.addEgde(5,4,6);
        graph.addEgde(5,2,4);
        graph.addEgde(3,5,2);

        System.out.println("Graph");
        graph.printGraph();
        System.out.println("MST");
        graph.kruskalMST();
        graph.dijkstra_GetMinDistances(sourceVertex);
    }
}
