
// package com.chuck.common.spring.aop;

// import org.aopalliance.intercept.MethodInterceptor;
// import org.aopalliance.intercept.MethodInvocation;
// import org.springframework.aop.framework.ProxyFactory;

// /**
// * @author Chuck
// * @since 4/5/2021
// * @version 0.0.1
// *
// **/
// public class Agent {

// public void speak() {
// System.out.print("Bond");
// }
// }

// class AgentDecorator implements MethodInterceptor {

// @Override
// public Object invoke(MethodInvocation invocation) throws Throwable {
// System.out.print("James ");
// Object retVal = invocation.proceed();
// System.out.print("!");
// return retVal;
// }

// }

// class AgentAOPcommon {
// public static void main(String[] args) {
// Agent target = new Agent();
// ProxyFactory pf = new ProxyFactory();
// pf.addAdvice(new AgentDecorator());
// pf.setTarget(target);
// Agent proxy = (Agent) pf.getProxy();

// target.speak();
// System.out.println("");
// proxy.speak();
// }
// }