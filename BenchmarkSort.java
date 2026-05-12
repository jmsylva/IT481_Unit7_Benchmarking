import java.util.Arrays;
import java.util.Random;

/*
 * IT481 Unit 7 Assignment: Benchmarking
 * Author: Joshua Sylva
 *
 * This program benchmarks sorting algorithms using small, medium, and large data sets.
 *
 * References:
 * Bubble sort concept based on:
 * GeeksforGeeks. (2024). Bubble sort algorithm. https://www.geeksforgeeks.org/bubble-sort/
 *
 * Quick sort concept based on:
 * GeeksforGeeks. (2024). Quick sort algorithm. https://www.geeksforgeeks.org/quick-sort/
 */

public class BenchmarkSort {

    public static void main(String[] args) {
        int[] dataSizes = {10, 1000, 10000};

        System.out.println("IT481 Unit 7 Benchmarking Results");
        System.out.println("--------------------------------");

        for (int size : dataSizes) {
            int[] originalData = generateRandomData(size);

            int[] bubbleData = Arrays.copyOf(originalData, originalData.length);
            long bubbleTime = benchmarkBubbleSort(bubbleData);

            int[] optimizedData = Arrays.copyOf(originalData, originalData.length);
            long optimizedBubbleTime = benchmarkOptimizedBubbleSort(optimizedData);

            int[] quickData = Arrays.copyOf(originalData, originalData.length);
            long quickTime = benchmarkQuickSort(quickData);

            System.out.println("\nData Set Size: " + size);
            System.out.println("Bubble Sort Time: " + bubbleTime + " nanoseconds");
            System.out.println("Optimized Bubble Sort Time: " + optimizedBubbleTime + " nanoseconds");
            System.out.println("Quick Sort Time: " + quickTime + " nanoseconds");
        }
    }

    private static int[] generateRandomData(int size) {
        Random random = new Random(42);
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(100000);
        }

        return data;
    }

    private static long benchmarkBubbleSort(int[] data) {
        long startTime = System.nanoTime();
        BubbleSort.sort(data);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long benchmarkOptimizedBubbleSort(int[] data) {
        long startTime = System.nanoTime();
        OptimizedBubbleSort.sort(data);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long benchmarkQuickSort(int[] data) {
        long startTime = System.nanoTime();
        QuickSort.sort(data, 0, data.length - 1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
