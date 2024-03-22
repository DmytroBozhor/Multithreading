package dmytro.bozhor.concurrent.collections;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ArrayListPopulator implements Runnable {

    private final List<Integer> integerList;

    private final List<Integer> integerSynchronizedList;

    @Override
    public void run() {

        integerSynchronizedList.addAll(integerList);

    }
}
