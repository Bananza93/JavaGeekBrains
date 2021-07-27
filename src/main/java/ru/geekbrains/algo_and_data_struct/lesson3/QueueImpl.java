package ru.geekbrains.algo_and_data_struct.lesson3;

public class QueueImpl<E> implements Queue<E> {
    private final E[] data;
    private int size;

    private int headIndex;
    private int tailIndex;

    @SuppressWarnings("unchecked")
    public QueueImpl(int capacity) {
        if (capacity <= 0) throw  new IllegalArgumentException("Capacity must be > 0");
        data = (E[]) new Object[capacity];
        size = 0;
        headIndex = 0;
        tailIndex = -1;
    }

    @Override
    public boolean add(E value) {
        if (isFull()) return false;
        tailIndex = (tailIndex + 1) % data.length;
        data[tailIndex] = value;
        size++;
        return true;
    }

    @SafeVarargs
    public final void addAll(E... values) {
        if (isFull()) return;
        for (E value : values) {
            if (!add(value)) return;
        }
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;
        E elem = peek();
        headIndex = (headIndex + 1) % data.length;
        size--;
        return elem;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data[headIndex];
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
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int index = headIndex, iter = size; iter > 0; iter--, index = (index + 1) % data.length) {
            sb.append(data[index]);
            if (iter > 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
