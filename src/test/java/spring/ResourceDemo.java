
// package com.chuck.common.spring;

// import java.io.File;
// import java.io.IOException;

// import org.springframework.context.ApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.core.io.Resource;

// /**
// * @author Chuck
// * @since 4/5/2021
// * @version 0.0.1
// *
// **/
// public class Resourcecommon {
// public static void main(String[] args) throws IOException {

// ApplicationContext ctx = new ClassPathXmlApplicationContext();
// File file = File.createTempFile("test", "txt");
// file.deleteOnExit();

// Resource rs1 = ctx.getResource("file://" + file.getPath());
// Resource rs2 = ctx.getResource("classpath:test.txt");
// Resource rs3 = ctx.getResource("http://www.google.com");

// displatyInfo(rs3);
// }

// private static void displatyInfo(Resource res) throws IOException {
// System.out.println(res.getClass());
// System.out.println(res.getURL().getContent());
// System.out.println("");
// }
// }
