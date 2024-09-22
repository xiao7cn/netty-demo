package org.example;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class TestNettyPromise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EventLoop eventLoop = new NioEventLoopGroup().next();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventLoop);
        new Thread(() -> {
            System.out.println("开始计算...");
            try {
                int i = 1 / 0;
                Thread.sleep(1000);
            } catch (Throwable e) {
                e.printStackTrace();
                promise.setFailure(e);
            }
            promise.setSuccess(80);
        }).start();

        log.debug("等待结果...");
        log.debug("结果是: {}", promise.get());
    }
}
