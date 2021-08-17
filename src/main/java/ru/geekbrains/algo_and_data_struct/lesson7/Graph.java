package ru.geekbrains.algo_and_data_struct.lesson7;

import java.util.Stack;

public interface Graph {
    boolean addVertex(String label);
    boolean addEdge(String fromLabel, String toLabel, int weight);
    int size();
    void display();
    void findShortestPath(String startLabel, String endLabel);
}
