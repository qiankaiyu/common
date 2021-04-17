
// package com.chuck.common.spring;

// import java.util.Locale;

// import org.springframework.context.support.GenericXmlApplicationContext;

// /**
// * @author Chuck
// * @since 4/5/2021
// * @version 0.0.1
// *
// **/
// public class MessageSourcecommon {

// public static void main(String[] args) {
// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
// ctx.load("classpath:spring/app-context.xml");
// ctx.refresh();

// Locale en = Locale.ENGLISH;
// Locale ge = Locale.GERMAN;
// System.out.println(ctx.getMessage("msg", null, en));
// System.out.println(ctx.getMessage("msg", null, ge));
// System.out.println(ctx.getMessage("nameMsg", new Object[] { "John", "Mayer"
// }, en));
// System.out.println(ctx.getMessage("nameMsg", new Object[] { "John", "Mayer"
// }, ge));
// }
// }
