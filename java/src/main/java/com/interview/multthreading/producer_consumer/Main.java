package com.interview.multthreading.producer_consumer;

public class Main {
    public static void main(String[] args) {
        CommonQueue queue = new CommonQueue(5);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}
