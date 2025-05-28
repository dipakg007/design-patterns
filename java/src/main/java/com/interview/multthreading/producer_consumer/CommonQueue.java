package com.interview.multthreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class CommonQueue {
    final Queue<Integer> queue = new LinkedList<>();
    int capacity;

    CommonQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(Integer value) {
        while (queue.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(value);
        System.out.println(Thread.currentThread().getName() + " Value added: " + value);
        notifyAll();
    }

    public synchronized void get() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Integer value = queue.poll();
        System.out.println(Thread.currentThread().getName() + " Value poll: " + value);
        notifyAll();
    }

}
