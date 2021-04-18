package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
public class CompletedMachina {
    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        try {
            cf.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        }
    }
}
