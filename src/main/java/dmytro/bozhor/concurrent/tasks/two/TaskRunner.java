package dmytro.bozhor.concurrent.tasks.two;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Stream;

public class TaskRunner {
    @SneakyThrows
    public static void main(String[] args) {

        var details = new ArrayBlockingQueue<Detail>(4);

        var detailProducer = new DetailProducer(details);
        var detailConsumerOne = new DetailConsumer(details);
        var detailConsumerTwo = new DetailConsumer(details);

        Stream.of(detailProducer, detailConsumerOne, detailConsumerTwo)
                .map(Thread::new)
                .forEach(Thread::start);

    }
}
