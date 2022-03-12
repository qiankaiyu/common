package com.chuck.common.utils.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * 推荐自己有意识关闭
 *
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 **/
public class IOUtils {
    /**
     * 关闭对象，连接
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
