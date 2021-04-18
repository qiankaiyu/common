package concurrency.quit;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import concurrency.executor.Nap;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
public class QuittingCompletable {

    private static final int COUNT = 10;

    public static void main(String[] args) {
        List<QuittableTask> tasks = IntStream.range(1, COUNT).mapToObj(QuittableTask::new).collect(Collectors.toList());
        List<CompletableFuture> cfutures = tasks.stream().map(CompletableFuture::runAsync).collect(Collectors.toList());
        new Nap(0.1);
        tasks.forEach(QuittableTask::quit);
        cfutures.forEach(CompletableFuture::join);
    }
}
