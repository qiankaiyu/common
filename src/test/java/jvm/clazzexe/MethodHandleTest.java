
package jvm.clazzexe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * MethodHandleTest
 */
public class MethodHandleTest {
    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClazzA();
        getPrintMH(obj).invokeExact("i want been printed!!!");
    }

    /**
     * 模拟invokevirtual的过程
     *
     *
     * methodHandle可以当做函数指针传递到sort(List list,MethodHandle compare)方法中
     *
     * @param receiver
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     */
    private static MethodHandle getPrintMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType mt = MethodType.methodType(Void.class, String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }

    static class ClazzA {
        public void println(String s) {
            System.out.println(s);
        }
    }
}