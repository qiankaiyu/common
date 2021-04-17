
// package com.chuck.common.spring;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.context.support.GenericXmlApplicationContext;
// import org.springframework.core.env.ConfigurableEnvironment;
// import org.springframework.core.env.MapPropertySource;
// import org.springframework.core.env.MutablePropertySources;

// /**
// * @author Chuck
// * @since 4/2/2021
// * @version 0.0.1
// *
// **/
// public class EnvironmentSample {
// public static void main(String[] args) {
// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
// ctx.refresh();

// ConfigurableEnvironment env = ctx.getEnvironment();
// MutablePropertySources pSources = env.getPropertySources();

// Map<String, Object> appMap = new HashMap<>();
// appMap.put("user.name", "application_home");

// // addFirst可以控制搜索的第一个属性
// pSources.addLast(new MapPropertySource("prospring5 MAP", appMap));

// System.out.println("user.home: " + System.getProperty("user.home"));
// System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));

// System.out.println("user.home: " + env.getProperty("user.home"));
// System.out.println("JAVA_HOME: " + env.getProperty("JAVA_HOME"));

// ctx.close();
// }
// }
