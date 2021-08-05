package ru.geekbrains.algo_and_data_struct.lesson3;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int capacity) {
        super(capacity);
    }

    @Override
    public boolean addFirst(E value) {
        if (isFull()) return false;
        headIndex = (headIndex + (data.length - 1)) % data.length;
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
        E elem = data[headIndex];
        headIndex = (headIndex + 1) % data.length;
        size--;
        return elem;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        E elem = data[tailIndex];
        tailIndex = (tailIndex + (data.length - 1)) % data.length;
        size--;
        return elem;
    }

    @Override
    public E peekFirst() {
        return isEmpty() ? null : data[headIndex];
    }

    @Override
    public E peekLast() {
        return isEmpty() ? null : data[tailIndex];
    }
}
