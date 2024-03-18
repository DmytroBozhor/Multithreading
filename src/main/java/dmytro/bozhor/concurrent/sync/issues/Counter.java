package dmytro.bozhor.concurrent.sync.issues;

import lombok.Getter;

@Getter
public class Counter {

    private int counter;

    public void increment() {
        counter++;
    }
}
