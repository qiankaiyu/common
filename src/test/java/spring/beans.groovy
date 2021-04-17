package com.chuck.common.spring

beans {
    singer(Singer, name:'John Mayer', age:39)
}
static main(args) {
    ApplicationContext ctx=new GenericGroovyApplicationContext("classpath:beans.groovy");
    Singer s=ctx.getBean("singer",Singer.class);
    System.out.println(s);
}
