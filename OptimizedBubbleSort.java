/*
 * Optimized Bubble Sort
 * This version stops early if a full pass completes without any swaps.
 * That helps improve performance when the data is already sorted or nearly sorted.
 */

public class OptimizedBubbleSort {

    public static void sort(int[] data) {
        int n = data.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
