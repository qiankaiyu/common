package concurrency.executor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用ExecutorService（Future、Callable）替代Executor
 * 
 * @author Chuck
 * @since 4/17/2021
 * @version 0.0.1
 *
 **/
@Slf4j
public class FutureRender {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    void renderPage(CharSequence source) {
        // 创建并提交下载图像任务
        final List<ImageInfo> infos = scanForImageInfo(source);
        Callable<List<ImageData>> task = () -> {
            return infos.stream().map(ImageInfo::downloadImage).collect(Collectors.toList());
        };
        Future<List<ImageData>> future = executor.submit(task);
        // 渲染文本
        renderText(source);
        // 渲染图像
        try {
            List<ImageData> images = future.get();
            images.stream().forEach(this::renderImage);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            future.cancel(true);
            log.info("执行任务失败，错误：{}", e.getMessage());
        }
    }

    private void renderImage(ImageData image) {
    }

    private void renderText(CharSequence source) {
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        return null;
    }

    static class ImageInfo {
        public ImageData downloadImage() {
            return null;
        }
    }

    static class ImageData {

    }
}
