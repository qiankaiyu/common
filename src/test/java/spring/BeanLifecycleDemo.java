
// package com.chuck.common.spring;

// import javax.annotation.PostConstruct;
// import javax.annotation.PreDestroy;

// import org.springframework.beans.BeansException;
// import org.springframework.beans.factory.BeanNameAware;
// import org.springframework.beans.factory.DisposableBean;
// import org.springframework.beans.factory.InitializingBean;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContextAware;
// import
// org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Lazy;
// import org.springframework.context.support.GenericApplicationContext;
// import org.springframework.context.support.GenericXmlApplicationContext;

// import lombok.Data;

// /**
// * @author Chuck
// * @since 4/5/2021
// * @version 0.0.1
// *
// **/
// public class BeanLifecyclecommon {

// }

// /**
// * 自动注册关闭Hook
// *
// * @author Chuck
// * @since 2021年4月4日
// * @version 0.0.1
// *
// *
// */
// class ShutdownHookBean implements ApplicationContextAware {

// @Override
// public void setApplicationContext(ApplicationContext ctx) throws
// BeansException {
// if (ctx instanceof GenericApplicationContext) {
// ((GenericApplicationContext) ctx).registerShutdownHook();
// }

// }

// }

// class NameSinger implements BeanNameAware {
// private String name;

// @Override
// public void setBeanName(String name) {
// this.name = name;
// }
// }

// @Configuration
// class SingerConfigcommon {
// @Lazy
// @Bean(initMethod = "init", destroyMethod = "destroy")
// Singer singerOne() {
// Singer singer = new Singer();
// singer.setName("JM");
// singer.setAge(39);
// return singer;
// }

// @Lazy
// @Bean(initMethod = "init")
// Singer singerTwo() {
// Singer singer = new Singer();
// singer.setAge(72);
// return singer;
// }

// @Lazy
// @Bean(initMethod = "init")
// Singer singerThree() {
// Singer singer = new Singer();
// singer.setName("JB");
// return singer;
// }

// public static void main(String[] args) {
// GenericApplicationContext ctx = new
// AnnotationConfigApplicationContext(SingerConfigcommon.class);
// getBean("singerOne", ctx);
// getBean("singerTwo", ctx);
// getBean("singerThree", ctx);
// }

// public static Singer getBean(String beanName, ApplicationContext ctx) {
// Singer bean = (Singer) ctx.getBean(beanName);
// System.out.println(bean);
// return bean;
// }
// }

// class SingerWithJSR250 {
// @PostConstruct
// public void init() {
// //
// }

// @PreDestroy
// public void destory() {
// //
// }
// }

// @Data
// class SingerWithInterface implements InitializingBean, DisposableBean {
// static final String DEFAULT_NAME = "Eric Clapton";

// private String name;

// private int age = Integer.MIN_VALUE;

// @Override
// public void afterPropertiesSet() throws Exception {
// // ...
// }

// @Override
// public void destroy() throws Exception {
// //
// }

// }

// @Data
// class Singer {
// private static final String DEFAULT_NAME = "Eric Clapton";

// private String name;

// private int age = Integer.MIN_VALUE;

// public void init() {
// System.out.println("Initializing Bean");
// if (name == null) {
// System.out.println("Using default Name");
// name = DEFAULT_NAME;
// }
// if (age == Integer.MIN_VALUE) {
// throw new IllegalArgumentException("Must set the age property of any bean");
// }
// }

// public void destory() {

// }

// public static void main(String[] args) {
// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
// ctx.load("classpath:spring/app-context.xml");
// ctx.refresh();
// //
// }

// }
