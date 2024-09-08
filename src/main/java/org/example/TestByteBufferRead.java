package org.example;

import java.nio.ByteBuffer;

import static org.example.utils.ByteBufferUtil.debugAll;

public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

//        buffer.get(new byte[4]);
//        debugAll(buffer);
//        buffer.rewind();
//        System.out.println((char) buffer.get());

//        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());
//        buffer.mark();
//        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());
//        buffer.reset();
//        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());

        System.out.println((char) buffer.get(3));
        debugAll(buffer);
    }
}
