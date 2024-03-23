package dmytro.bozhor.concurrent.tasks.one;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Random;

@AllArgsConstructor
public class ConsumerThread extends Thread {

    private LinkedList<Integer> integerList;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (!integerList.isEmpty()) {
                System.out.println("Receiving new element: " + integerList.pop());
                System.out.println("List size: " + integerList.size());
            }
            Thread.sleep(new Random().nextInt(10));
        }
    }
}
