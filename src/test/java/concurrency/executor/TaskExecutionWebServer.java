package concurrency.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 使用Executor替代Thread执行任务
 * 
 * @author Chuck
 * @since 4/17/2021
 * @version 0.0.1
 *
 **/
public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor EXECUTORS = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(80);
        while (true) {
            final Socket s = ss.accept();
            Runnable task = () -> handleRequest(s);
            EXECUTORS.execute(task);
        }

    }

    private static Runnable handleRequest(Socket s) {
        return null;
    }
}
