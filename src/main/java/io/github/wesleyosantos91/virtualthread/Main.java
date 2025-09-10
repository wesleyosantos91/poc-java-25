package io.github.wesleyosantos91.virtualthread;

import static java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor;

public class Main {

    static void main() {
        try (var executor = newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                executor.submit(() -> {
                    System.out.println(Thread.currentThread());
                    Thread.sleep(1000);
                    return null;
                });
            }
        }
    }
}
