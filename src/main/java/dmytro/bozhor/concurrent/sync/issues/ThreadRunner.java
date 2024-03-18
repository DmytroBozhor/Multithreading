package dmytro.bozhor.concurrent.sync.issues;

import lombok.SneakyThrows;

public class ThreadRunner {

    @SneakyThrows
    public static void main(String[] args) {

        var counter = new Counter();

        var counterThreadOne = new CounterThread(counter);
        var counterThreadTwo = new CounterThread(counter);
        var counterThreadThree = new CounterThread(counter);

        counterThreadOne.start();
        counterThreadTwo.start();
        counterThreadThree.start();

        counterThreadOne.join();
        counterThreadTwo.join();
        counterThreadThree.join();

        System.out.println(counter.getCounter());

    }
}
