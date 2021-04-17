class Handler {

    def f1() {
        println 'f1 of Handler called...'
    }
    def f2() {
        println 'f2 of Handler called...'
    }

}

class Example {

    def f1() { println 'f1 of Example called...' }

    def f2() { println 'f2 of Example called...' }

    def foo(closure) {
        closure.delegate = new Handler()
        // 为什么设置了owner，调用的还是handler的f2方法？
        closure.owner = new Example()
        closure()
    }

}

def f1() {
    println 'f1 of Script called...'
}

new Example().foo {
    f1()//this.f1()
    f2()
}
