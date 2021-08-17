package ru.geekbrains.algo_and_data_struct.lesson7;

public class Lesson7_HW {
    public static void main(String[] args) {
        GraphImpl gr = new GraphImpl(10);

        gr.addVertex("A");
        gr.addVertex("B");
        gr.addVertex("C");
        gr.addVertex("D");
        gr.addVertex("E");
        gr.addVertex("F");
        gr.addVertex("G");
        gr.addVertex("H");
        gr.addVertex("I");
        gr.addVertex("J");

        gr.addEdge("A","B",5);
        gr.addEdge("A","C",7);
        gr.addEdge("A","D",6);
        gr.addEdge("B","D",5);
        gr.addEdge("B","E",7);
        gr.addEdge("C","F",4);
        gr.addEdge("C","G",11);
        gr.addEdge("D","E",3);
        gr.addEdge("D","H",8);
        gr.addEdge("E","G",5);
        gr.addEdge("F","G",13);
        gr.addEdge("F","J",9);
        gr.addEdge("G","I",8);
        gr.addEdge("H","I",6);
        gr.addEdge("H","J",8);
        gr.addEdge("I","J",5);

        gr.findAllShortestPaths("B");
        System.out.println();
        gr.findShortestPath("B", "D");
        gr.findShortestPath("B", "G");
        gr.findShortestPath("B", "H");
        gr.findShortestPath("B", "J");
//
//        gr.display();
    }
}
