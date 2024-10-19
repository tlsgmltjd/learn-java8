package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello! " + Thread.currentThread().getName());
            return "HELLO";
        });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("World! " + Thread.currentThread().getName());
            return "WORLD";
        });

//        CompletableFuture<String> combineFutures = completableFuture.thenCombine(completableFuture2, (h, w) -> h + " " + w);
//        System.out.println(combineFutures.get());

        // CompletableFuture.allOf(): 모든 task들이 끝나면 thenAccept를 실행한다.
        // 여러 task들의 반환 타입이 일치할거라는 보장도 없고 task중에 예외가 발생할 수 있으므로 결과값이 의미가 없다. (null이 나온다)
        CompletableFuture<Void> future = CompletableFuture.allOf(completableFuture, completableFuture2)
                .thenAccept((result) -> {
                    System.out.println(result);
                });

        System.out.println(future);

        List<CompletableFuture<String>> futures = Arrays.asList(completableFuture, completableFuture2);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> result = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join) // join도 blocking 하게되는데 un checked exception이니 예외처리 필수 X
                        .collect(Collectors.toList()));

        result.get().forEach(System.out::println);

        CompletableFuture<Void> f = CompletableFuture.anyOf(completableFuture, completableFuture2)
                .thenAccept(s -> System.out.println("--------- " + s));
        f.get();


    }
}

