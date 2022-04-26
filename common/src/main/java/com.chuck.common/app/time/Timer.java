package com.chuck.common.app.time;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
public class Timer {

    private long start = System.nanoTime();

    public long duration() {
        return NANOSECONDS.toMillis(System.nanoTime() - start);
    }

    public static long duration(Runnable test) {
        Timer timer = new Timer();
        test.run();
        return timer.duration();
    }
}
