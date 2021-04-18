package concurrency.quit;

import java.util.concurrent.atomic.AtomicBoolean;

import concurrency.executor.Nap;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
public class QuittableTask implements Runnable {

    private final int id;

    QuittableTask(int id) {
        this.id = id;
    }

    // volatile
    private static AtomicBoolean shutdown = new AtomicBoolean(Boolean.FALSE);

    @Override
    public void run() {
        while (!shutdown.get()) {
            new Nap(0.1);
        }
    }

    void quit() {
        shutdown.set(Boolean.TRUE);
    }
}
