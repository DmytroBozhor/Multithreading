package dmytro.bozhor.concurrent.tasks.two;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@Getter
@Setter
public class DetailConsumer implements Runnable {

    private ArrayBlockingQueue<Detail> details;

    private List<Detail> detailList = new ArrayList<>();

    public DetailConsumer(ArrayBlockingQueue<Detail> details) {
        this.details = details;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            detailList.add(details.take());
            System.out.println(Thread.currentThread().getName() + " took the detail. " + detailList);
        }
    }
}
