package dmytro.bozhor.concurrent.task;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedList;

public class ThreadRunner {
    @SneakyThrows
    public static void main(String[] args) {
        var integerList = new LinkedList<Integer>();

        var producerThread = new ProducerThread(integerList);
        var consumerThread = new ConsumerThread(integerList);
        var consumerThread2 = new ConsumerThread(integerList);

        producerThread.start();
        consumerThread.start();
        consumerThread2.start();

        producerThread.join();
        consumerThread.join();
        consumerThread2.join();

        System.out.println("End");

    }
}
