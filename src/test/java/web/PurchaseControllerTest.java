
// package com.chuck.common.web;

// import java.util.HashMap;
// import java.util.Map;

// import com.chuck.common.controllers.PurchaseController.Result;

// import org.json.JSONObject;
// import org.json.JSONString;
// import org.junit.Test;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.web.client.RestTemplateBuilder;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.MediaType;
// import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
// import
// org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
// import org.springframework.web.client.RestTemplate;

// import net.minidev.json.JSONAware;
// import net.minidev.json.parser.JSONParser;

// /**
// * @author Chuck
// * @since 1/7/2021
// * @version
// *
// **/
// // @Slf4j
// @SpringBootTest
// public class PurchaseControllerTest {
// Logger log = LoggerFactory.getLogger(this.getClass());

// @Test
// public void purchase() {

// Map<String, Integer> map = new HashMap<>();
// map.put("userId", 1);
// map.put("productId", 1);
// map.put("quantity", 10);

// HttpHeaders headers = new HttpHeaders();
// headers.setContentType(MediaType.APPLICATION_JSON);

// JSONObject obj = new JSONObject();
// try {
// obj.put("userId", 1);
// obj.put("productId", 1);
// obj.put("quantity", 10);
// } catch (Exception e) {
// // TODO: handle exception
// }

// HttpEntity<String> request = new HttpEntity<>(obj.toString(), headers);
// try {
// for (int i = 0; i < 1000; i++) {
// RestTemplate temp = new RestTemplateBuilder().basicAuthentication("chuck",
// "asdasd123").build();

// new Thread(() -> {
// Result res = temp.postForObject("http://localhost:8080/purchase", request,
// Result.class);
// // log.info("purchase success : %s, msg: %s", res.success, res.msg);
// System.out.println("-------------------------------------------------------");
// System.out.format("purchase success : %s, msg: %s", res.isSuccess(),
// res.getMsg());
// }).start();
// }

// } catch (Exception e) {
// // log.info(e.getStackTrace().toString());
// e.printStackTrace();
// }
// }
// }
