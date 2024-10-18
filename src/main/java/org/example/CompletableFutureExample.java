package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // CompletableFuture 뒤에 then 메서드 체이닝으로 작업이 모두 처리되었을 때 콜백 함수로 실행해준다.
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello! " + Thread.currentThread().getName());
            return "HELLO";
            // 콜백함수의 반환값이 있을때 thenApply
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toLowerCase();
        });

        System.out.println(completableFuture2.get());


        CompletableFuture<Void> completableFuture3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello! " + Thread.currentThread().getName());
            return "HELLO";
            // 콜백함수의 반환값이 없을때 thenAccept
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println(completableFuture3.get());


        CompletableFuture<Void> completableFuture4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello! " + Thread.currentThread().getName());
            return "HELLO";
            // 콜백함수의 반환값이 없고 파라미터도 안받을때 thenRun
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println(completableFuture4.get());
    }
}
