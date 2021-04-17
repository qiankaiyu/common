package com.chuck.common.dynamictype;
// package com.chuck.common.groovy.dynamictype;

// import java.math.BigDecimal;

// /**
// * @author Chuck
// * @since 2/27/2021
// * @version
// *
// * Java的多方法基于目标对象
// **/
// public class MultiMethodJava {
// public static void main(String[] args) {
// giveRaise(new Employee());
// giveRaise(new Executive());
// }

// static void giveRaise(Employee employee) {
// employee.raise(new BigDecimal(10000.0));
// }
// }

// class Employee {
// public void raise(Number amount) {
// System.out.println("Employee got raise");
// }
// }

// class Executive extends Employee {
// public void raise(Number amount) {
// System.out.println("Executive got raise");
// }

// public void raise(BigDecimal amount) {
// System.out.println("Executive got outlandish raise");
// }
// }