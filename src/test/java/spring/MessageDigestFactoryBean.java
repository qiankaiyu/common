
// package com.chuck.common.spring;

// import java.security.MessageDigest;

// import org.springframework.beans.factory.FactoryBean;
// import org.springframework.beans.factory.InitializingBean;
// import
// org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.support.GenericApplicationContext;
// import org.springframework.context.support.GenericXmlApplicationContext;

// import lombok.Setter;

// /**
// * FactoryBean
// *
// * @author Chuck
// * @since 4/4/2021
// * @version 0.0.1
// *
// **/
// public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>,
// InitializingBean {
// @Setter
// private String algorithmName = "MD5";

// private MessageDigest messageDigest = null;

// @Override
// public void afterPropertiesSet() throws Exception {
// messageDigest = MessageDigest.getInstance(algorithmName);
// }

// @Override
// public MessageDigest getObject() throws Exception {
// return messageDigest;
// }

// @Override
// public Class<?> getObjectType() {

// return MessageDigest.class;
// }

// public boolean isSingleton() {
// return Boolean.TRUE;
// }

// }

// /**
// * ageDigester
// */
// class MessageDigester {
// @Setter
// private MessageDigest digest1;
// @Setter
// private MessageDigest digest2;

// public void digest(String msg) {
// System.out.println("Using digest1...");
// digest(msg, digest1);
// System.out.println("Using digest2...");
// digest(msg, digest2);
// }

// private void digest(String msg, MessageDigest digest) {
// System.out.println("Using Algorithm: " + digest.getAlgorithm());
// digest.reset();
// byte[] bytes = msg.getBytes();
// byte[] out = digest.digest(bytes);
// System.out.println(out);
// }

// public static void main(String[] args) {
// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
// ctx.load("classpath://spring/app-context.xml");
// ctx.refresh();
// MessageDigester digester = ctx.getBean("degester", MessageDigester.class);
// digester.digest("Hello World!");

// ctx.close();
// }
// }

// @Configuration
// class MessageDigesterConfig {
// @Bean
// public MessageDigestFactoryBean shaDigest() {
// MessageDigestFactoryBean one = new MessageDigestFactoryBean();
// one.setAlgorithmName("SHA1");
// return one;
// }

// @Bean
// public MessageDigestFactoryBean defaultDigest() {
// return new MessageDigestFactoryBean();
// }

// @Bean
// MessageDigester digester() throws Exception {
// MessageDigester md = new MessageDigester();
// md.setDigest1(shaDigest().getObject());
// md.setDigest2(defaultDigest().getObject());
// return md;
// }

// public static void main(String[] args) {
// GenericApplicationContext ctx = new
// AnnotationConfigApplicationContext(MessageDigesterConfig.class);
// MessageDigester md = (MessageDigester) ctx.getBean("digester");
// MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean)
// ctx.getBean("&digester");
// try {
// System.out.println("Equal ?" + (factoryBean.getObject() == (MessageDigest)
// ctx.getBean("shaDigest")));
// } catch (Exception e) {
// e.printStackTrace();
// }

// md.digest("Hello World!");
// ctx.close();
// }
// }