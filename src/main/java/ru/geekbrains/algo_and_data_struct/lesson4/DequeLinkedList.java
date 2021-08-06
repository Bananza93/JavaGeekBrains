package ru.geekbrains.algo_and_data_struct.lesson4;

public class DequeLinkedList<E> extends SimpleLinkedListImpl<E> implements Deque<E> {

    //private Node<E> firstNode = null;
    protected Node<E> lastNode = null;
    //private int size;

    @Override
    public boolean addFirst(E element) {
        if (isEmpty()) {
            lastNode = firstNode = new Node<>(element, lastNode, firstNode);
        } else {
            Node<E> currentFirst = firstNode;
            firstNode = new Node<>(element, null, currentFirst);
            currentFirst.setPrevious(firstNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (isEmpty()) {
            lastNode = firstNode = new Node<>(element, lastNode, firstNode);
        } else {
            Node<E> currentLast = lastNode;
            lastNode = new Node<>(element, currentLast, null);
            currentLast.setNext(lastNode);
        }
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> removed = firstNode;
        firstNode = removed.getNext();
        firstNode.setPrevious(null);
        size--;
        return removed.getData();
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        Node<E> removed = lastNode;
        lastNode = removed.getPrevious();
        lastNode.setNext(null);
        size--;
        return removed.getData();
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        return firstNode.getData();
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        return lastNode.getData();
    }

    @Override
    public boolean add(E element) {
        return addFirst(element);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException();
    }

    /*@Override
    public Iterator<E> iterator() {
        return new DequeLinkedListIterator();
    }

    private class DequeLinkedListIterator implements Iterator<E> {
        private Node<E> current;
        private Node<E> next;
        private int nextIndex;

        DequeLinkedListIterator() {
            next = DequeLinkedList.this.firstNode;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            current = next;
            next = next.getNext();
            nextIndex++;
            return current.getData();
        }
    }*/
}
