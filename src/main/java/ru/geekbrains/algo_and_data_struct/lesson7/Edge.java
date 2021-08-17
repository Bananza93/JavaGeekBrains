package ru.geekbrains.algo_and_data_struct.lesson7;

public class Edge {
    private final int sourceIndex;
    private final int destinationIndex;
    private final int weight;

    public Edge(int sourceIndex, int destinationIndex, int weight) {
        this.sourceIndex = sourceIndex;
        this.destinationIndex = destinationIndex;
        this.weight = weight;
    }

    public int getSourceIndex() {
        return sourceIndex;
    }

    public int getDestinationIndex() {
        return destinationIndex;
    }

    public int getWeight() {
        return weight;
    }

}
