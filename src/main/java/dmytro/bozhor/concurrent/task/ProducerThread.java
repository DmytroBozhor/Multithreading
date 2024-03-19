package dmytro.bozhor.concurrent.task;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class ProducerThread extends Thread {

    private List<Integer> integerList;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (integerList.size() < 10) {
                var randomInt = new Random().nextInt();
                integerList.add(randomInt);
                System.out.println("Adding new element: " + randomInt);
                System.out.println("List size: " + integerList.size());
            }
            Thread.sleep(3);
        }
    }
}
