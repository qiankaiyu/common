
// package com.chuck.common.spring;

// import org.springframework.beans.BeansException;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContextAware;
// import org.springframework.context.ApplicationEvent;
// import org.springframework.context.ApplicationListener;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

// import lombok.Getter;
// import lombok.Setter;

// /**
// * @author Chuck
// * @since 4/5/2021
// * @version 0.0.1
// *
// **/
// public class MessageEvent extends ApplicationEvent {
// @Getter
// private String msg;

// public MessageEvent(Object source, String msg) {
// super(source);
// this.msg = msg;
// }

// }

// class MessageEventListener implements ApplicationListener<MessageEvent> {

// @Override
// public void onApplicationEvent(MessageEvent event) {
// MessageEvent ev = event;
// System.out.println("Received: " + ev.getMsg());
// }

// }

// class Publisher implements ApplicationContextAware {
// @Setter
// private ApplicationContext ctx;

// @Override
// public void setApplicationContext(ApplicationContext applicationContext)
// throws BeansException {

// }

// public void publish(String msg) {
// ctx.publishEvent(new MessageEvent(this, msg));
// }

// public static void main(String[] args) {
// ApplicationContext ctx = new
// ClassPathXmlApplicationContext("classpath:spring/app-context.xml");
// Publisher pub = (Publisher) ctx.getBean("publisher");
// pub.publish("I Send an SOS to the world...");
// pub.publish("... I hope that some gets my ...");
// pub.publish("... Message in a bottle");
// }
// }