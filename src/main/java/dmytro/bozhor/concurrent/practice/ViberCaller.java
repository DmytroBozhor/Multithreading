package dmytro.bozhor.concurrent.practice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ViberCaller implements Runnable {

    private CallerUtil caller;

    @Override
    public void run() {
        caller.talkViaViber();
    }
}
