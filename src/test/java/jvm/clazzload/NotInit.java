package jvm.clazzload;

/**
 * @author Chuck
 * @since 3/7/2021
 * @version
 *
 **/
public class NotInit {
    public static void main(String[] args) {
        // System.out.println(SubClazz.value); 不会初始化SubClazz
        // SuperClazz[] sca = new SuperClazz[10]; 不会初始化SuperClazz
        // System.out.println(ConstClazz.HELLOWORLD);不会初始化ConstClazz
    }
}

class SuperClazz {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}

class SubClazz extends SuperClazz {
    static {
        System.out.println("SubClass init!");
    }
}

class ConstClazz {
    static {
        System.out.println("ConstClazz init!");
    }
    public static final String HELLOWORLD = "hello world!!!";
}
