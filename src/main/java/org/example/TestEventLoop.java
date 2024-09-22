package org.example;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestEventLoop {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup(2);
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());

        group.next().submit(() -> {
            log.debug("11");
        });

        group.next().submit(() -> {
            log.debug("22");
        });

        group.next().submit(() -> {
            log.debug("33");
        });

        log.debug("main");
    }
}
