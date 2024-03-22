package dmytro.bozhor.concurrent;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " " + getState());
    }
}
