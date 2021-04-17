
package jvm.clazzexe;

/**
 * @author Chuck
 * @since 3/8/2021
 * @version
 *
 **/
public class StaticDispatch {
    public void sayHello(Human human) {
        System.out.println("hello guys!");
    }

    public void sayHello(Man man) {
        System.out.println("hello man!");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
}

abstract class Human {
}

class Man extends Human {

}

class Woman extends Human {

}