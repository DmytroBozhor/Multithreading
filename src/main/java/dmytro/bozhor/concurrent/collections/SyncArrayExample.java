package dmytro.bozhor.concurrent.collections;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Stream;

public class SyncArrayExample {
    public static void main(String[] args) {

        var integerSynchronizedList = Collections.synchronizedList(new ArrayList<Integer>());

        var integerList = new ArrayList<Integer>();

        for (int i = 0; i < 1000; i++) {
            integerList.add(i);
        }

        var arrayListPopulator = new ArrayListPopulator(integerList, integerSynchronizedList);

        Stream.of(
                        arrayListPopulator,
                        arrayListPopulator,
                        arrayListPopulator,
                        arrayListPopulator,
                        arrayListPopulator,
                        arrayListPopulator
                )
                .map(Thread::new)
                .forEach(SyncArrayExample::startThread);

        System.out.println(integerSynchronizedList.size());


    }

    @SneakyThrows
    private static void startThread(Thread thread) {
        thread.start();
        thread.join();
    }
}
