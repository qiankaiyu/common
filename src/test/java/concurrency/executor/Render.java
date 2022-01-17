package concurrency.executor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;

import concurrency.executor.FutureRender.ImageData;
import concurrency.executor.FutureRender.ImageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用CompletionService替代ExecutorService
 * 
 * @author Chuck
 * @since 4/17/2021
 * @version 0.0.1
 *
 **/
@Slf4j
@RequiredArgsConstructor
public class Render {

    private final Executor executor;

    void renderPage(CharSequence source) {
        final List<ImageInfo> infos = scanForImageInfo(source);
        CompletionService<ImageData> cs = new ExecutorCompletionService<>(executor);
        // infos.stream().map(FutureRender.ImageInfo::downloadImage).map(Callable::new);
        for (ImageInfo imageInfo : infos) {
            cs.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }
            });
        }
        renderText(source);
        for (int i = 0; i < infos.size(); i++) {
            Future<ImageData> f;
            try {
                f = cs.take();
                ImageData image = f.get();
                renderImage(image);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                log.info("渲染图片失败，错误：{}", e.getMessage());
            }
        }
    }

    private void renderImage(ImageData image) {
    }

    private void renderText(CharSequence source) {
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        return null;
    }
}
