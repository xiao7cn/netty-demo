package org.example.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelCallableExample {
    public static void main(String[] args) {
        // 创建一个ExecutorService实例
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 创建多个Callable任务
        List<Callable<Integer>> tasks = Arrays.asList(
                () -> {
                    Thread.sleep(1000);
                    return 1;
                },
                () -> {
                    Thread.sleep(2000);
                    return 2;
                },
                () -> {
                    Thread.sleep(3000);
                    return 3;
                }
        );

        try {
            // 并行执行所有Callable任务并获得结果列表
            List<Future<Integer>> futures = executor.invokeAll(tasks);

            // 聚合结果
            for (Future<Integer> future : futures) {
                System.out.println("Result: " + future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭ExecutorService
            executor.shutdown();
        }
    }
}