package dmytro.bozhor.concurrent.tasks.two;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;

@Getter
@Setter
@AllArgsConstructor
public class DetailProducer implements Runnable {

    private ArrayBlockingQueue<Detail> details;

    @SneakyThrows
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            var detailAmount = RandomUtil.getRandomInt(4);
            for (int j = 0; j <= detailAmount; j++) {
                details.put(Detail.getRandomDetail());
                System.out.println("Producer put a new detail: " + details);
            }
            Thread.sleep(100L);
        }

    }

}
