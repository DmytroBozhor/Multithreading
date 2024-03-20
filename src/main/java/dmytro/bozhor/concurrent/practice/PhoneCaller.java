package dmytro.bozhor.concurrent.practice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhoneCaller implements Runnable {

    private CallerUtil caller;

    @Override
    public void run() {
        caller.talkOnThePhone();
    }
}
