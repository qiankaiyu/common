
// package com.chuck.common.spring;

// import java.beans.PropertyEditorSupport;
// import java.io.File;
// import java.io.IOException;
// import java.io.InputStream;
// import java.net.URL;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.List;
// import java.util.Locale;
// import java.util.Properties;
// import java.util.regex.Pattern;

// import org.springframework.beans.PropertyEditorRegistrar;
// import org.springframework.beans.PropertyEditorRegistry;
// import org.springframework.beans.propertyeditors.CustomDateEditor;
// import org.springframework.beans.propertyeditors.StringTrimmerEditor;
// import org.springframework.context.support.GenericApplicationContext;
// import org.springframework.context.support.GenericXmlApplicationContext;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.Setter;

// /**
// * PropertyEditor
// *
// * @author Chuck
// * @since 4/5/2021
// * @version 0.0.1
// *
// **/
// @Setter
// public class PropertyEditorBean {
// private byte[] bytes;

// private Character character;

// private Class clazz;

// private Boolean trueOrFalse;

// private List<String> strList;

// private Date date;

// private Float floatVal;

// private File file;

// private InputStream stream;

// private Locale locale;

// private Pattern pattern;

// private Properties properties;

// private String trimString;

// private URL url;

// }

// class CustomPropertyEditorRegistry implements PropertyEditorRegistrar {

// @Override
// public void registerCustomEditors(PropertyEditorRegistry registry) {
// SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
// // 内置PropertyEditor
// registry.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
// // 内置PropertyEditor
// registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
// }

// public static void main(String[] args) throws IOException {
// File file = File.createTempFile("test", "txt");
// file.deleteOnExit();
// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
// ctx.load("classpath:context.xml");
// ctx.refresh();

// PropertyEditorBean bean = (PropertyEditorBean) ctx.getBean("buildInSample");
// ctx.close();
// }
// }

// @Data
// @AllArgsConstructor
// class FullName {
// private String firstName;
// private String lastName;

// public static void main(String[] args) {
// GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
// ctx.load("classpath:spring/app-context.xml");
// ctx.refresh();

// //
// ctx.close();
// }
// }

// /**
// * 自定义编辑器
// *
// * @author Chuck
// * @since 2021年4月5日
// * @version 0.0.1
// *
// *
// */
// class NamePropertyEditor extends PropertyEditorSupport {
// @Override
// public void setAsText(String text) throws IllegalArgumentException {
// String[] name = text.split("\\s");
// setValue(new FullName(name[0], name[1]));
// }
// }