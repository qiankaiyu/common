package concurrency.executor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
@Slf4j
@RequiredArgsConstructor
public class NapTask implements Runnable {
    final int id;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        new Nap(0.1);
        log.info("{} {}", this, Thread.currentThread().getName());
    }

}
