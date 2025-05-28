package com.interview.multthreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class CommonQueue {
    final Queue<Integer> queue = new LinkedList<>();
    int capacity;

    CommonQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(Integer value) {
        synchronized (queue) {
            while (queue.size() >= capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(value);
            System.out.println(Thread.currentThread().getName() + " Value added: " + value);
            queue.notifyAll();
        }
    }

    public void get() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Integer value = queue.poll();
            System.out.println(Thread.currentThread().getName() + " Value poll: " + value);
            queue.notifyAll();
        }
    }

}
