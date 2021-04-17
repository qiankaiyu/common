@groovy.transform.CompileStatic
def shout(String str) {
    println str.toUpperCase()//为什么不能省略括号
}
shout('abcde')
