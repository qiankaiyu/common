
package jvm;

/**
 * @author Chuck
 * @since 3/2/2021
 * @version
 *
 *          java -Xss144k StackSOF.java
 *
 *
 *          VM Args: -Xss128k
 **/
public class StackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF oom = new StackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLength:" + oom.stackLength);
            throw e;
        }
    }
}
