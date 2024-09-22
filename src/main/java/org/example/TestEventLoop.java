package org.example;

import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TestEventLoop {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup(2);

        CountDownLatch countDownLatch = new CountDownLatch(8);
        group.submit(() -> {
            log.debug("aa {}", Thread.currentThread());
            countDownLatch.countDown();
        });
        group.submit(() -> {
            log.debug("bb {}", Thread.currentThread());
            countDownLatch.countDown();
        });
        group.submit(() -> {
            log.debug("cc {}", Thread.currentThread());
            countDownLatch.countDown();
        });
        group.submit(() -> {
            log.debug("dd {}", Thread.currentThread());
            countDownLatch.countDown();
        });

        EventLoop eventLoop1 = group.next();
        eventLoop1.submit(() -> {
            log.debug("11 {}", Thread.currentThread());
            countDownLatch.countDown();
        });
        EventLoop eventLoop2 = group.next();
        eventLoop2.submit(() -> {
            log.debug("22 {}", Thread.currentThread());
            countDownLatch.countDown();
        });
        EventLoop eventLoop3 = group.next();
        eventLoop3.submit(() -> {
            log.debug("33 {}", Thread.currentThread());
            countDownLatch.countDown();
        });
        EventLoop eventLoop4 = group.next();
        eventLoop4.submit(() -> {
            log.debug("44 {}", Thread.currentThread());
            countDownLatch.countDown();
        });

        group.next().scheduleAtFixedRate(() -> {
            log.debug("ok");
        }, 0, 100, TimeUnit.MILLISECONDS);

        countDownLatch.await();
        log.debug("main");

        group.shutdownGracefully();
    }
}
