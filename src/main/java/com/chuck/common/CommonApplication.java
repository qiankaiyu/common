package com.chuck.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Chuck
 * @since 2021年4月9日
 * @version 0.0.1
 *
 *
 */
@Slf4j
@EnableCaching
@SpringBootApplication
public class CommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonApplication.class, args);

		// System.out.println("#Beans:" + ctx.getBeanDefinitionCount());
		// String[] names=ctx.getBeanDefinitionNames();
		// Arrays.stream(names).sorted().forEach(System.out::println);

	}

}
