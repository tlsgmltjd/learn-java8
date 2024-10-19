package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayParallelSort {
    public static void main(String[] args) throws InterruptedException {
        int size = 1000000;
        int[] numbers = new int[size];
        Random random = new Random();

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numbers); // 기본 sort, "싱글스레드"로 동작함 java에서는 듀얼 피봇 퀵 소트를 씀 (O n log n)
        long s =(System.nanoTime() - start);
        System.out.println("Serial sorting took: " + s);

        Thread.sleep(1000L);

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start2 = System.nanoTime();
        Arrays.parallelSort(numbers); // parallel sort, 여러 스레드로 분산해서 소트를 진행한다.
        long p = (System.nanoTime() - start2);
        System.out.println("Parallel sorting took: " + p);

        System.out.println(p > s ? "기본정렬 승" : "패러럴 정렬 승");

        // Serial sorting took: 149977250
        // Parallel sorting took: 72030666
        // 패러럴 정렬 승
    }
}
