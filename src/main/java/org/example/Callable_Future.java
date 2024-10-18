package org.example;

import java.util.List;
import java.util.concurrent.*;

public class Callable_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };

        Callable<String> python = () -> {
            Thread.sleep(1000L);
            return "python";
        };

        // invokeAll로 여러 Callable들을 실행할 수 있다. 하지만 모든 Callabll 작업이 끝날 때 까지 기다린다.
//        List<Future<String>> futures = executorService.invokeAll(List.of(hello, java, python));
//        for (Future<String> future : futures) {
//            System.out.println(future.get());
//        }

        // invokeAny는 가장 먼저 끝나는 작업의 반환값을 반환한다. 마찬가지로 blocking
        String s = executorService.invokeAny(List.of(hello, java, python));
        System.out.println(s);

        executorService.shutdown();
    }
}
