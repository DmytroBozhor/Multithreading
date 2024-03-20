package dmytro.bozhor.concurrent.practice;

import lombok.SneakyThrows;

public class CallerUtil {

    private static final Object MUTEX = new Object();

    private static long sleepTime = 3000L;

    @SneakyThrows
    public void talkOnThePhone() {
        synchronized (MUTEX) {
            System.out.println("Making a phone call");
            Thread.sleep(sleepTime);
        }
    }

    @SneakyThrows
    public void talkViaViber() {
        synchronized (MUTEX) {
            System.out.println("Making a viber call");
            Thread.sleep(sleepTime);
        }
    }

    @SneakyThrows
    public void talkViaSkype() {
        synchronized (MUTEX) {
            System.out.println("Making a skype call");
            Thread.sleep(sleepTime);
        }
    }

    public static long getSleepTime() {
        return sleepTime;
    }

    public static void setSleepTime(long sleepTime) {
        CallerUtil.sleepTime = sleepTime;
    }
}
