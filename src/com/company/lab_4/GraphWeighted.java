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
    ArrayList<Edge> allEdges = new ArrayList<>();

    GraphWeighted(int vertices) {
        this.vertices = vertices;
    }

    public void addEgde(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        allEdges.add(edge);
    }

    public void kruskalMST(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
        pq.addAll(allEdges);

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

    public void makeSet(int[] parent){
        for (int i = 0; i < vertices ; i++) {
            parent[i] = i;
        }
    }

    public int find(int[] parent, int vertex){
        if(parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        return vertex;
    }

    public void union(int [] parent, int x, int y){
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);

        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }

    public void printGraph(){
        for (Edge edge : allEdges) {
            System.out.println("Source: " + edge.source +
                    " destination: " + edge.destination +
                    " weight: " + edge.weight);
        }
}

    public void printMST(ArrayList<Edge> edgeList){
        for (Edge edge : edgeList) {
            System.out.println("Source: " + edge.source +
                    " destination: " + edge.destination +
                    " weight: " + edge.weight);
        }
    }
}