package com.chuck.common.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/18/2021
 * @version 0.0.1
 *
 **/
@Slf4j
public class CompletableUtilities {

    // Get and show value stored in a CF:
    public static void showr(CompletableFuture<?> c) {
        try {
            log.info("{}", c.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // For CF operations that have no value:
    public static void voidr(CompletableFuture<Void> c) {
        try {
            c.get(); // Returns void
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
