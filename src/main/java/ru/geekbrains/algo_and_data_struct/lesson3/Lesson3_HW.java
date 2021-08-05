package ru.geekbrains.algo_and_data_struct.lesson3;

import java.util.Arrays;

public class Lesson3_HW {

    public static void main(String[] args) {
        findMissingNumberEx();
        queueEx();
        dequeEx();
    }

    private static int findMissingNumber(int[] array) {
        if (array.length == 0) return 1;

        int firstIndex = 0;
        int lastIndex = array.length - 1;

        while (lastIndex > firstIndex) {
            int mid = (firstIndex + lastIndex) / 2;
            if (array[mid] == mid + 1) {
                firstIndex = mid + 1;
            } else if (mid > 0 && lastIndex - firstIndex != 1) {
                lastIndex = mid - 1;
            } else {
                lastIndex = mid;
            }
        }

        if (array[firstIndex] - firstIndex == 2) return array[firstIndex] - 1;
        else return array[firstIndex] + 1;
    }

    private static void findMissingNumberEx() {
        //Empty array test
        System.out.println(findMissingNumber(new int[0]));
        //One element array
        System.out.println(findMissingNumber(new int[] {1}));
        System.out.println(findMissingNumber(new int[] {2}));
        //Other tests
        for (int size = 2; size <= 20; size++) {
            int[] array = new int[size];
            int skipNumber = (int) (Math.random() * (size + 1)) + 1;
            for (int number = 1, index = 0; index < size; number++) {
                if (number == skipNumber) continue;
                array[index] = number;
                index++;
            }
            int result = findMissingNumber(array);
            System.out.println(Arrays.toString(array));
            System.out.println("Skip number = " + skipNumber);
            System.out.println("Result      = " + result);
            System.out.println();
        }
    }

    private static void queueEx() {
        QueueImpl<Integer> queue = new QueueImpl<>(8);
        System.out.println("Queue created (capacity = " + queue.size() + ")");
        queue.display();
        System.out.println("Add: 8");
        queue.add(8);
        queue.display();
        System.out.println("Add: 4,5,1,10,-1,123,0");
        queue.addAll(4,5,1,10,-1,123,0);
        queue.display();
        System.out.println("First element: " + queue.peek());
        System.out.println("Remove: " + queue.remove());
        System.out.println("Remove: " + queue.remove());
        System.out.println("Remove: " + queue.remove());
        System.out.println("First element: " + queue.peek());
        queue.display();
        queue.addAll(8800,555,3535);
        queue.display();
        System.out.println();
    }

    private static void dequeEx() {
        DequeImpl<Integer> deque = new DequeImpl<>(8);
        System.out.println("Deque created (capacity = " + deque.size() + ")");
        deque.display();
        System.out.println("Add first: 10,31,21,12");
        System.out.println("Add last: 8,5,3,7");
        deque.addLast(8);
        deque.addLast(5);
        deque.addFirst(10);
        deque.addFirst(31);
        deque.addLast(3);
        deque.addFirst(21);
        deque.addLast(7);
        deque.addFirst(12);
        deque.display();
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());
        System.out.println("Remove first: " + deque.removeFirst());
        System.out.println("Remove last: " + deque.removeLast());
        System.out.println("Remove first: " + deque.removeFirst());
        deque.display();
        System.out.println("Add first: 1111");
        System.out.println("Add last: 123,321");
        deque.addLast(123);
        deque.addLast(321);
        deque.addFirst(1111);
        deque.display();
    }
}
