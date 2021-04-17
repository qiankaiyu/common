
// package com.chuck.common;

// import java.lang.reflect.Method;
// import java.lang.reflect.Proxy;
// import java.util.List;
// import java.util.Optional;

// import javax.persistence.PersistenceUnitUtil;
// import javax.persistence.criteria.CriteriaBuilder;

// import com.chuck.common.model.Address;
// import com.chuck.common.model.Customer;
// import com.chuck.common.model.Person;
// import com.chuck.common.repository.CustomerRepository;
// import com.chuck.common.repository.PersonRepo;

// import org.junit.jupiter.api.Test;
// import org.junit.runner.JUnitCore;
// import org.springframework.beans.BeanWrapper;
// import org.springframework.beans.factory.BeanFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
// import
// org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.cglib.core.KeyFactory;
// import org.springframework.cglib.proxy.MethodInterceptor;
// import org.springframework.cglib.proxy.MethodProxy;
// import org.springframework.core.convert.ConversionService;
// import org.springframework.http.converter.HttpMessageConverter;
// import
// org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
// import org.springframework.validation.DataBinder;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.SessionAttribute;
// import org.springframework.web.servlet.DispatcherServlet;
// import org.springframework.web.servlet.HandlerAdapter;
// import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
// import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

// @SpringBootTest
// class commonApplicationTests {
// // @Autowired
// CustomerRepository repo;

// // @Autowired
// private PersonRepo personRepo;

// // @Test
// void contextLoads() {
// }

// // @Test
// public void testPeristenct() {
// Address addr = new Address();
// addr.setCity("JX");
// addr.setState("CN");
// addr.setStreet("some street");
// addr.setZipCode("343111");
// Customer customer = new Customer("Chuck", "yu");
// customer.setAddress(addr);
// // repo.save(customer);
// }

// // @Test
// void test() {
// // HandlerAdapter
// // HandlerMapping
// // WebMvcAutoConfiguration
// // HttpMessageConverter
// // WebMvcAutoConfigurationAdapter
// // LocaleChangeInterceptor
// // MappingJackson2HttpMessageConverter
// // mockito

// }

// // @Test
// public void querypersonTest() {
// List<Person> p = personRepo.findByName("java");
// System.out.println(p);
// // JUnitCore

// }
// }

// class Trace implements MethodInterceptor {

// @Override
// public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy
// arg3) throws Throwable {
// // TODO Auto-generated method stub

// return null;
// }

// }
