package jvm.autobox;

/**
 * @author Chuck
 * @since 3/25/2021
 * @version 0.0.1
 *
 **/
public class AutoBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); // true
        System.out.println(e == f); // false
        // c==Integer.valueOf((Integer.intValue(a)+Integer.intValue(b)))
        System.out.println(c == (a + b));// true
        // c.equals... Integer.valueOf((Integer.intValue(a)+Integer.intValue(b)))
        System.out.println(c.equals(a + b));// true
        // g== Integer.valueOf((Integer.intValue(a)+Integer.intValue(b)))
        System.out.println(g == (a + b));// false X
        // g.equals... Integer.valueOf((Integer.intValue(a)+Integer.intValue(b)))
        System.out.println(g.equals(a + b));// true X

    }

    /**
     * 上述代码的反编译结果
     */
    void deCompilerResult() {
        Integer var1 = Integer.valueOf(1);
        Integer var2 = Integer.valueOf(2);
        Integer var3 = Integer.valueOf(3);
        Integer var4 = Integer.valueOf(3);
        Integer var5 = Integer.valueOf(321);
        Integer var6 = Integer.valueOf(321);
        Long var7 = Long.valueOf(3L);
        System.out.println(var3 == var4);
        System.out.println(var5 == var6);
        System.out.println(var3.intValue() == var1.intValue() + var2.intValue());
        System.out.println(var3.equals(Integer.valueOf(var1.intValue() + var2.intValue())));
        System.out.println(var7.longValue() == (long) (var1.intValue() + var2.intValue()));
        System.out.println(var7.equals(Integer.valueOf(var1.intValue() + var2.intValue())));
    }
}
