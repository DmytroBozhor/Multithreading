package dmytro.bozhor;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " " + getState());
    }
}
