package coreJava.multiThreading.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture is part of Java 8’s java.util.concurrent package, providing a way to handle asynchronous programming.
 * It allows non-blocking calls and chaining with thenApply, thenAccept, etc.
 */
public class CompletableFutureDemo extends CompletableFuture {

    public static void main(String[] args) {
        CompletableFutureDemo.supplyAsync(() -> "Hello")
                .thenApply(msg -> msg + " World")
                .thenAccept(System.out::println); // Prints "Hello World"

    }
}
