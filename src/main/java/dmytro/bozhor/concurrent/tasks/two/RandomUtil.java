package dmytro.bozhor.concurrent.tasks.two;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtil {

    private static Random random;

    public static Random getInstance() {
        initIfNull();
        return random;
    }

    public static int getRandomInt(int bound) {
        initIfNull();
        return random.nextInt(bound);
    }

    private static void initIfNull() {
        if (random == null) {
            random = new Random();
        }
    }
}
