package dmytro.bozhor.concurrent.sync.issues;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CounterThread extends Thread {

    private Counter counter;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
