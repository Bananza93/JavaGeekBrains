package ru.geekbrains.algo_and_data_struct.lesson3;

public class DequeImpl<E> implements Deque<E> {
    private final E[] data;
    private int size;

    private int headIndex;
    private int tailIndex;

    @SuppressWarnings("unchecked")
    public DequeImpl(int capacity) {
        if (capacity <= 0) throw  new IllegalArgumentException("Capacity must be > 0");
        data = (E[]) new Object[capacity];
        size = 0;
        headIndex = 0;
        tailIndex = -1;
    }

    @Override
    public boolean addFirst(E value) {
        if (isFull()) return false;
        headIndex = (headIndex + data.length - 1) % data.length;
        data[headIndex] = value;
        size++;
        return true;
    }

    @Override
    public boolean addLast(E value) {
        if (isFull()) return false;
        tailIndex = (tailIndex + 1) % data.length;
        data[tailIndex] = value;
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        E elem = peekFirst();
        headIndex = (headIndex + 1) % data.length;
        size--;
        return elem;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        E elem = peekLast();
        tailIndex = (tailIndex + data.length - 1) % data.length;
        size--;
        return elem;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        return data[headIndex];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        return data[tailIndex];
    }

    @Override
    public boolean add(E value) {
        return addLast(value);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
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
