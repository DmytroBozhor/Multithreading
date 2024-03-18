package dmytro.bozhor.concurrent.queue.example;

import lombok.SneakyThrows;

import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Stream;

public class ThreadRunner {
    @SneakyThrows
    public static void main(String[] args) {

        var cashBoxes = new ArrayDeque<>(List.of(new CashBox(), new CashBox()));

        var start = System.currentTimeMillis();

        var threadList = Stream.of(
                        new Buyer(cashBoxes),
                        new Buyer(cashBoxes),
                        new Buyer(cashBoxes),
                        new Buyer(cashBoxes),
                        new Buyer(cashBoxes)
                )
                .map(Thread::new)
                .peek(Thread::start).toList();

        for (Thread thread : threadList) {
            thread.join();
        }

        var finish = System.currentTimeMillis();

        System.out.println(finish - start);

    }
}
