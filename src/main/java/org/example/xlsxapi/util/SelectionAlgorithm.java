package org.example.xlsxapi.util;

import java.util.List;
import java.util.Random;

public class SelectionAlgorithm {

    private static final Random rand = new Random();

    public static int select(List<Integer> list, int left, int right, int n) {
        if (left == right) return list.get(left);

        int pivotIndex = partition(list, left, right);

        if (n == pivotIndex) {
            return list.get(n);
        } else if (n < pivotIndex) {
            return select(list, left, pivotIndex - 1, n);
        } else {
            return select(list, pivotIndex + 1, right, n);
        }
    }

    private static int partition(List<Integer> list, int left, int right) {
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotValue = list.get(pivotIndex);
        swap(list, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (list.get(i) < pivotValue) {
                swap(list, storeIndex, i);
                storeIndex++;
            }
        }

        swap(list, storeIndex, right);
        return storeIndex;
    }

    private static void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}