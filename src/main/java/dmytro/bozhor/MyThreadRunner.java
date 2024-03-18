package dmytro.bozhor;

import lombok.SneakyThrows;

public class MyThreadRunner {

    private static Thread currentThread = Thread.currentThread();

    @SneakyThrows
    public static void main(String[] args) {

        var myThread = new MyThread();
        myThread.start();
        myThread.join(100L);

        System.out.println(currentThread.getName() + " " + currentThread.getState());

    }
}