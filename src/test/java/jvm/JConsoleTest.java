
package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuck
 * @since 3/6/2021
 * @version
 *
 *
 *
 *          -Xms100m -Xmx100m -XX:+UseSerialGC
 **/
public class JConsoleTest {
    static class OOMObject {// 64KB
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
