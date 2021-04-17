
package jvm;

/**
 * @author Chuck
 * @since 3/2/2021
 * @version
 * @javadoc Mark
 *
 *
 *          intern会将首次遇到的字符串复制到字符串常量池（java8中在堆中），所以str1在堆中和new
 *          StringBuilder是同一个对象
 *
 *          而字符串java不是首次遇到，不会被复制到字符串常量池中
 **/
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
