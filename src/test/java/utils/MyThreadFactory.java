package utils;

import java.util.concurrent.ThreadFactory;

/**
 * 创建自定义Thread
 * 
 * @author Chuck
 * @since 4/16/2021
 * @version 0.0.1
 *
 **/
public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {

        return new Thread(r);
    }
}
