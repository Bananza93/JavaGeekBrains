package ru.geekbrains.algo_and_data_struct.lesson8;

import java.util.Objects;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 30;
    private int capacity;
    private int size;
    private int threshold;
    private Node<K, V>[] nodes;

    @SuppressWarnings("unchecked")
    public HashTableImpl(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        else if (initialCapacity > MAX_CAPACITY)
            capacity = MAX_CAPACITY;
        else
            this.capacity = getCorrectCapacity(initialCapacity);
        this.size = 0;
        this.threshold = (int) (capacity * LOAD_FACTOR);
        nodes = (Node<K, V>[]) new Node[capacity];
    }

    private int getCorrectCapacity(int initialCapacity) {
        int n = -1 >>> Integer.numberOfLeadingZeros(initialCapacity - 1);
        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }

    public HashTableImpl() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean put(K key, V value) {
        if (size == threshold) resize();
        putVal(hashFunc(key), key, value);
        size++;
        return true;
    }

    private void putVal(int hash, K key, V value) {
        int index = (capacity - 1) & hash;
        if (nodes[index] != null && nodes[index].getKey().equals(key)) {
            nodes[index].setValue(value);
        } else {
            nodes[index] = new Node<>(hash, key, value, nodes[index]);
        }
    }

    private int hashFunc(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if (capacity >= MAX_CAPACITY) {
            threshold = Integer.MAX_VALUE;
        } else {
            capacity <<= 1;
            threshold = (int) (capacity * LOAD_FACTOR);
            Node<K, V>[] currNodes = nodes;
            nodes = new Node[capacity];
            for (Node<K, V> node : currNodes) {
                if (node != null) {
                    putVal(node.hash, node.key, node.value);
                    Node<K, V> next = node.next;
                    while (next != null) {
                        putVal(next.hash, next.key, next.value);
                        next = next.next;
                    }
                }
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        Node<K, V> node = nodes[hashFunc(key) % capacity];
        while (node != null) {
            if (Objects.equals(node.key, key)) return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Node<K, V> node : nodes) {
            if (node != null) {
                if (Objects.equals(node.value, value)) return true;
                Node<K, V> next = node.next;
                while (next != null) {
                    if (Objects.equals(next.value, value)) return true;
                    next = next.next;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = nodes[hashFunc(key) % capacity];
        while (node != null) {
            if (Objects.equals(node.key, key)) return node.value;
            node = node.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Node<K, V> node = nodes[hashFunc(key) % capacity];
        Node<K, V> previousNode = null;
        while (node != null) {
            if (Objects.equals(node.key, key)) {
                if (previousNode == null) {
                    nodes[hashFunc(key) % capacity] = node.next;
                } else {
                    previousNode.next = node.next;
                }
                size--;
                return node.value;
            }
            previousNode = node;
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = nodes[i];
            System.out.print(i + " -> " + node);
            while (node != null) {
                node = node.next;
                if (node != null) System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

    static class Node<K, V> implements Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}