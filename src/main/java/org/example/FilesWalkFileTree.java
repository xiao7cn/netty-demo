package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class FilesWalkFileTree {
    public static void main(String[] args) throws IOException {

        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        Files.walkFileTree(Paths.get("/Users/xiaoqi/code/finpoints/bss/crm-fund"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException
            {
                System.out.println("====>" + dirCount);
                dirCount.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                System.out.println(file);
                fileCount.incrementAndGet();
                return super.visitFile(file, attrs);
            }
        });

        System.out.println("dir count : " + dirCount);
        System.out.println("file count : " + fileCount);
    }
}
