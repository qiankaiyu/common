@groovy.transform.TypeChecked
def shout(String str) {
    println 'Printing in uppercase'
    println str.toUpperCase()
    println 'Printing again in uppercase'
    // println str.toUppercase()
}

shout('abcde')
