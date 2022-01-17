package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
public class CompletableApply {
    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        CompletableFuture<Machina> cf2 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf3 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf4 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf5 = cf.thenApply(Machina::work);

        CompletableFuture<Machina> cf6 = CompletableFuture.completedFuture(new Machina(0)).thenApply(Machina::work)
                .thenApply(Machina::work).thenApply(Machina::work).thenApply(Machina::work);

        CompletableFuture<Machina> c7 = CompletableFuture.completedFuture(new Machina(0)).thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work).thenApplyAsync(Machina::work).thenApplyAsync(Machina::work);
    }
}
