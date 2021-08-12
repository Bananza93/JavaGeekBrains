package ru.geekbrains.algo_and_data_struct.lesson6;

import java.util.Stack;

public class BinaryTreeImpl<E extends Comparable<? super E>> implements BinaryTree<E> {

    private int size;
    private Node<E> root;
    private int currentLevel;
    private final int MAX_LEVEL;

    public BinaryTreeImpl(int maxLevel) {
        this.MAX_LEVEL = maxLevel;
    }

    @Override
    public boolean add(E value) {
        if (value == null) return false;
        Node<E> node = new Node<>(value);
        NodeAndParent nodeAndParent = find(value);
        if (nodeAndParent.current != null || nodeAndParent.level > MAX_LEVEL) return false;
        if (nodeAndParent.previous == null) {
            root = node;
        } else if (nodeAndParent.previous.toLeftDirection(value)) {
            nodeAndParent.previous.setLeftChild(node);
        } else {
            nodeAndParent.previous.setRightChild(node);
        }
        if (currentLevel < nodeAndParent.level) currentLevel = nodeAndParent.level;
        size++;
        return true;
    }

    @Override
    public int getCurrentDepth() {
        return currentLevel;
    }

    @Override
    public boolean contains(E value) {
        return find(value).current != null;
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isBalanced() {
        return checkBalance(root);
    }

    private boolean checkBalance(Node<E> node) {
        return (node == null) || checkBalance(node.leftChild) && checkBalance(node.rightChild) && Math.abs(height(node.leftChild) - height(node.rightChild)) <= 1;
    }

    private int height(Node<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    private NodeAndParent find(E value) {
        Node<E> current = root;
        Node<E> parent = null;
        int currLevel = 1;

        while (current != null) {
            if (current.value.equals(value)) break;
            parent = current;
            if (current.toLeftDirection(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            currLevel++;
        }
        return new NodeAndParent(current, parent, currLevel);
    }


    private class Node<T extends Comparable<? super T>> {

        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        private boolean toLeftDirection(T value) {
            return this.value.compareTo(value) > 0;
        }

        private boolean toRightDirection(T value) {
            return this.value.compareTo(value) < 0;
        }
    }

    private class NodeAndParent {
        Node<E> current;
        Node<E> previous;
        int level;

        public NodeAndParent(Node<E> current, Node<E> previous, int level) {
            this.current = current;
            this.previous = previous;
            this.level = level;
        }
    }
}
