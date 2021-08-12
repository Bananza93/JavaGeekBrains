package ru.geekbrains.algo_and_data_struct.lesson6;

public class Lesson6_HW {
    public static void main(String[] args) {
        int maxLevel = 6;
        int treeNumber = 3;
        int balancedTreeCount = 0;
        for (int i = 0; i < treeNumber; i++) {
            BinaryTree<Integer> tree = new BinaryTreeImpl<>(maxLevel);
            while(tree.getCurrentDepth() < maxLevel) {
                tree.add((int) (Math.random() * 201) - 100);
            }
            tree.display();
            if (tree.isBalanced()) balancedTreeCount++;
        }
        System.out.println(balancedTreeCount);
        System.out.println("Процент сбалансированных деревьев " + ((double) balancedTreeCount / treeNumber * 100) + "%");
    }
}
