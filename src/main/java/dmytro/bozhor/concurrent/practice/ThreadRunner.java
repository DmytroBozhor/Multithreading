package dmytro.bozhor.concurrent.practice;

import lombok.SneakyThrows;

import java.util.stream.Stream;

public class ThreadRunner {
    @SneakyThrows
    public static void main(String[] args) {


        CallerUtil.setSleepTime(200L);

        var threadList = Stream.of(
                        new PhoneCaller(new CallerUtil()),
                        new PhoneCaller(new CallerUtil()),
                        new PhoneCaller(new CallerUtil()),
                        new SkypeCaller(new CallerUtil()),
                        new SkypeCaller(new CallerUtil()),
                        new SkypeCaller(new CallerUtil()),
                        new ViberCaller(new CallerUtil()),
                        new ViberCaller(new CallerUtil()),
                        new ViberCaller(new CallerUtil()))
                .map(Thread::new)
                .peek(Thread::start)
                .toList();

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("end");

    }
}
