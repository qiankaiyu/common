package concurrency;

import java.lang.Thread.UncaughtExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/16/2021
 * @version 0.0.1
 *
 **/
@Slf4j
public class ExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.error("Thread:{}\n", t.getId());
        log.error("Exception: {}:{}", e.getClass().getName(), e.getMessage());
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> Integer.parseInt("TTT"));
        t.setUncaughtExceptionHandler(new ExceptionHandler());
        t.start();
    }

}
