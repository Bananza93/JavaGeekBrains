package ru.geekbrains.algo_and_data_struct.lesson7;

import javafx.util.Pair;

import java.util.*;

public class GraphImpl implements Graph {
    private final List<Vertex> vertexList;
    private final int maxVertexCount;
    private final Map<Integer, LinkedList<Edge>> adjacencyList;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.maxVertexCount = maxVertexCount;
        adjacencyList = new HashMap<>();
    }

    @Override
    public boolean addVertex(String label) {
        if (label == null || size() == maxVertexCount) return false;
        Vertex v = new Vertex(label);
        if (!vertexList.contains(v)) {
            vertexList.add(v);
            adjacencyList.put(vertexList.size() - 1, new LinkedList<>());
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(String fromLabel, String toLabel, int weight) {
        if (fromLabel == null || toLabel == null || weight <= 0) return false;

        int fromIndex = findIndex(fromLabel);
        int toIndex = findIndex(toLabel);
        if (fromIndex != -1 && toIndex != -1 && fromIndex != toIndex) {
            adjacencyList.get(fromIndex).add(new Edge(fromIndex, toIndex, weight));
            adjacencyList.get(toIndex).add(new Edge(toIndex, fromIndex, weight));
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return vertexList.size();
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(vertexList.get(i).getLabel()).append(" -> { ");
            for (Edge edge : adjacencyList.get(i)) {
                sb.append(vertexList.get(edge.getDestinationIndex()).getLabel()).append("(").append(edge.getWeight()).append(") ");
            }
            sb.append("}\n");
        }
        System.out.println(sb);
    }

    @Override
    public void findShortestPath(String startLabel, String endLabel) {
        int startIndex = findIndex(startLabel);
        int endIndex = findIndex(endLabel);
        Pair<int[], int[]> pair = getMinDistancesAndPaths(startIndex);
        printPaths(pair.getKey(), pair.getValue(), startIndex, endIndex);
    }

    public void findAllShortestPaths(String startLabel) {
        int startIndex = findIndex(startLabel);
        Pair<int[], int[]> pair = getMinDistancesAndPaths(startIndex);
        printPaths(pair.getKey(), pair.getValue(), startIndex, -1);
    }

    private Pair<int[], int[]> getMinDistancesAndPaths(int sourceVertexIndex) {
        int[] path = new int[vertexList.size()];
        int[] distance = new int[vertexList.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(vertexList.size(), Comparator.comparingInt(Pair::getValue));

        distance[sourceVertexIndex] = 0;
        queue.offer(new Pair<>(sourceVertexIndex, distance[sourceVertexIndex]));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> extractedPair = queue.poll();
            int extractedVertex = extractedPair.getKey();
            if (!vertexList.get(extractedVertex).isProcessed()) {
                vertexList.get(extractedVertex).setProcessed(true);
                for (Edge edge : adjacencyList.get(extractedVertex)) {
                    int destinationIndex = edge.getDestinationIndex();
                    if (!vertexList.get(destinationIndex).isProcessed()) {
                        int newDistance = extractedPair.getValue() + edge.getWeight();
                        int currentDistance = distance[destinationIndex];
                        if (currentDistance > newDistance) {
                            distance[destinationIndex] = newDistance;
                            path[destinationIndex] = extractedVertex;
                            queue.offer(new Pair<>(destinationIndex, newDistance));
                        }
                    }
                }
            }
        }
        resetProcessedFlags();
        return new Pair<>(distance, path);
    }

    private void printPaths(int[] distance, int[] path, int sourceIndex, int destinationIndex) {
        for (int i = Math.max(destinationIndex, 0); i < (destinationIndex >= 0 ? destinationIndex + 1 : size()); i++) {
            StringBuilder sb = new StringBuilder();
            if (i != sourceIndex) {
                for (int j = i; ; ) {
                    j = path[j];
                    sb.insert(0, vertexList.get(j).getLabel()).insert(0, " ");
                    if (j == sourceIndex) break;
                }
            } else sb.insert(0, " Source");
            System.out.println("Source Vertex: " + vertexList.get(sourceIndex).getLabel()
                    + " to vertex " + vertexList.get(i).getLabel()
                    + " distance: " + distance[i]
                    + " | Path ->" + sb);
        }
    }

    private int findIndex(String label) {
        for (int i = 0; i < size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) return i;
        }
        return -1;
    }

    private void resetProcessedFlags() {
        for (Vertex vertex : vertexList) {
            vertex.setProcessed(false);
        }
    }
}
