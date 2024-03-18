package dmytro.bozhor.concurrent.sync.issues;

import lombok.SneakyThrows;

class ThreadRunner {
    public static void main(String[] args) {

        speedTest();

    }

    @SneakyThrows
    public static void speedTest() {

        var counter = new Counter();

        var counterThreadOne = new CounterThread(counter);
        var counterThreadTwo = new CounterThread(counter);
        var counterThreadThree = new CounterThread(counter);

        var start = System.currentTimeMillis();

        counterThreadOne.start();
        counterThreadTwo.start();
        counterThreadThree.start();

        counterThreadOne.join();
        counterThreadTwo.join();
        counterThreadThree.join();

        var finish = System.currentTimeMillis();

        System.out.println(finish - start);

        System.out.println(counter.getCounter());

    }
}
