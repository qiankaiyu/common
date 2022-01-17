package concurrency.executor;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
@Slf4j
public class Nap {
    public Nap(double t) {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (1000 * t));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    Nap(double t, String msg) {
        this(t);
        log.info("{}", msg);
    }
}
