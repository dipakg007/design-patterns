package com.interview.multthreading.producer_consumer;

public class Producer extends Thread {
    CommonQueue queue;

    Producer(CommonQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.put(i);
        }
    }
}
