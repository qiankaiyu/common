package com.chuck.common.groovy.dynamictype;

/**
* @author Chuck
* @since 2/28/2021
* @version 
*          Groovy的多方法基于目标对象（调用方法的对象）和参数类型
**/
class Employee
{
    public void raise(Number amount)
    {
        System.out.println("Employee got raise");
    }
}

class Executive extends Employee
{
    public void raise(Number amount)
    {
        System.out.println("Executive got raise");
    }

    public void raise(BigDecimal amount)
    {
        System.out.println("Executive got outlandish raise");
    }
}



def giveRaise(Employee employee)
{
    employee.raise(new BigDecimal(10000.0));
}
giveRaise(new Employee());
giveRaise(new Executive());