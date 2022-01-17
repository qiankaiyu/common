package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

import concurrency.executor.Nap;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
public class Workable {
    String id;
    final double duration;

    public Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable[" + id + "]";
    }

    public static Workable work(Workable tt) {
        new Nap(tt.duration); // Seconds
        tt.id = tt.id + "W";
        System.out.println(tt);
        return tt;
    }

    public static CompletableFuture<Workable> make(String id, double duration) {
        return CompletableFuture.completedFuture(new Workable(id, duration)).thenApplyAsync(Workable::work);
    }
}
