import spock.lang.Specification

class CalculatorTest extends Specification {

    // def "Multiply: #a * #b = #expectedResult"() {
    //     given: 'Calculator'
    //     def calc = new Calculator()

    //     when: 'multiply'
    //     def result = calc.multiply( a, b )

    //     then: 'result is as expected'
    //     result == expectedResult
    //     println "result = ${result}"

    //     where:
    //     a  | b | expectedResult
    //     1  | 2 | 3
    //     -5 | 2 | -3
    // }

    def "Add: #a + #b = #expectedResult"() {
        // given: 'Add'
        // def calc = new Calculator()

        when: 'add'
        def result = a + b

        then: 'result is as expected'
        result == expectedResult
        println "result = ${result}"

        where:
        a  | b | expectedResult
        1  | 2 | 3
        -5 | 2 | -3
    }

}

// Spock artifact: file:/Users/Chuck/Documents/dict/Maven-Jar/org/spockframework/spock-core/2.0-M4-groovy-3.0/spock-core-2.0-M4-groovy-3.0.jar

// Groovy artifact: file:/Users/Chuck/Documents/dict/Maven-Jar/org/codehaus/groovy/groovy/2.5.14/groovy-2.5.14.jar
