package org.example.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        // 创建一个ExecutorService实例
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 创建一个Callable任务
        Callable<Integer> task = () -> {
            // 模拟长时间的计算
            Thread.sleep(2000);
            return 123;
        };

        // 提交Callable任务并获得Future对象
        Future<Integer> future = executor.submit(task);

        try {
            // 阻塞并等待任务完成，然后获取结果
            Integer result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭ExecutorService
            executor.shutdown();
        }
    }
}
