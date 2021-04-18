package concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
@Slf4j
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        IntStream.range(0, 10).mapToObj(NapTask::new).forEach(executor::execute);
        log.info("All Tasks Submitted.");
        executor.shutdown();
        while (!executor.isTerminated()) {
            log.info("{} awaiting termination", Thread.currentThread().getName());
            new Nap(0.1);
        }
    }

}
