package dmytro.bozhor.concurrent.queue.example;

import lombok.SneakyThrows;

import java.util.Queue;

public class Buyer implements Runnable {

    private final Queue<CashBox> cashBoxes;

    public Buyer(Queue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (cashBoxes) {
                if (!cashBoxes.isEmpty()) {
                    var remove = cashBoxes.remove();
                    System.out.println(Thread.currentThread().getName() + " takes the monitor");

                    cashBoxes.wait(20L);

                    cashBoxes.add(remove);
                    System.out.println(Thread.currentThread().getName() + " returns the monitor");
                    cashBoxes.notifyAll();
                    break;
                } else {
                    cashBoxes.wait();
                    System.out.println(Thread.currentThread().getName() + " is waiting");
                }
            }
        }
    }
}
