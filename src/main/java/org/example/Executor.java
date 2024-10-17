package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Executor: 고수준 concurrency API
// Executor가 쓰레드를 만들고 관리해주는 작업을 하고 개발자는 Runnable 인터페이스만 구현해서 Executor에게 위임한다.
public class Executor {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

//        executorService.shutdown(); // graceful
//        executorService.shutdownNow(); // immediate
    }
}
