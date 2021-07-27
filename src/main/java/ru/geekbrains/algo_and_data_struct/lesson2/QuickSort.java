package ru.geekbrains.algo_and_data_struct.lesson2;

public class QuickSort {

    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array.length > 1_000_000) dualPivotQuicksort(array, 0, array.length - 1, 3);
        else quicksort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(T[] array, int fromIndex, int toIndex) {
        if (fromIndex < toIndex) {
            if (toIndex - fromIndex < 27) { // insertion sort for tiny array
                insertionSort(array, fromIndex, toIndex);
                return;
            }
            int pi = partition(array, fromIndex, toIndex);
            quicksort(array, fromIndex, pi);
            quicksort(array, pi + 1, toIndex);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int fromIndex, int toIndex) {
        T pivot = a[(fromIndex + toIndex) / 2];
        int i = fromIndex - 1;
        int j = toIndex + 1;

        while (true) {
            do {
                i++;
            }
            while (a[i].compareTo(pivot) < 0);

            do {
                j--;
            }
            while (a[j].compareTo(pivot) > 0);

            if (i >= j) {
                return j;
            }
            swap(a, i, j);
        }
    }

    private static <T extends Comparable<? super T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
        for (int i = fromIndex + 1; i <= toIndex; i++) {
            for (int j = i; j > fromIndex && array[j].compareTo(array[j - 1]) < 0; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    private static <T extends Comparable<? super T>> void swap(T[] array, int a, int b) {
        T tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    private static <T extends Comparable<? super T>> void dualPivotQuicksort(T[] array, int fromIndex, int toIndex, int div) {
        int len = toIndex - fromIndex;
        if (len < 27) { // insertion sort for tiny array
            insertionSort(array, fromIndex, toIndex);
            return;
        }
        int third = len / div;
        // "medians"
        int m1 = fromIndex + third;
        int m2 = toIndex - third;
        if (m1 <= fromIndex) {
            m1 = fromIndex + 1;
        }
        if (m2 >= toIndex) {
            m2 = toIndex - 1;
        }
        if (array[m1].compareTo(array[m2]) < 0) {
            swap(array, m1, fromIndex);
            swap(array, m2, toIndex);
        } else {
            swap(array, m1, toIndex);
            swap(array, m2, fromIndex);
        }
        // pivots
        T pivot1 = array[fromIndex];
        T pivot2 = array[toIndex];
        // pointers
        int less = fromIndex + 1;
        int great = toIndex - 1;
        // sorting
        for (int k = less; k <= great; k++) {
            if (array[k].compareTo(pivot1) < 0) {
                swap(array, k, less++);
            } else if (array[k].compareTo(pivot2) > 0) {
                while (k < great && array[great].compareTo(pivot2) > 0) {
                    great--;
                }
                swap(array, k, great--);
                if (array[k].compareTo(pivot1) < 0) {
                    swap(array, k, less++);
                }
            }
        }
        // swaps
        int dist = great - less;
        if (dist < 13) {
            div++;
        }
        swap(array, less - 1, fromIndex);
        swap(array, great + 1, toIndex);
        // subarrays
        dualPivotQuicksort(array, fromIndex, less - 2, div);
        dualPivotQuicksort(array, great + 2, toIndex, div);
        // equal elements
        if (dist > len - 13 && !pivot1.equals(pivot2)) {
            for (int k = less; k <= great; k++) {
                if (array[k].compareTo(pivot1) == 0) {
                    swap(array, k, less++);
                } else if (array[k].compareTo(pivot2) == 0) {
                    swap(array, k, great--);
                    if (array[k].compareTo(pivot1) == 0) {
                        swap(array, k, less++);
                    }
                }
            }
        }
        // subarray
        if (pivot1.compareTo(pivot2) < 0) {
            dualPivotQuicksort(array, less, great, div);
        }
    }
}
