
package jvm;

/**
 * @author Chuck
 * @since 3/6/2021
 * @version
 *
 *
 *          -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 **/
public class JHSDB {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.foo();
    }
}
