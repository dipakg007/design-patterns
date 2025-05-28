package com.interview.multthreading.producer_consumer;

public class Consumer extends Thread {
    CommonQueue queue;

    Consumer(CommonQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.get();
        }
    }
}
