package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(5000L);
                System.out.println("Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        });
        thread.start();

        System.out.println("Thread: " + Thread.currentThread().getName());
        thread.join(); // 해당 스레드를 기다린다.
        System.out.println(thread + " is done");

    }
}
