//package com.chuck.common;
//
//import javax.annotation.Resource;
//
//import com.chuck.common.repository.BookRepository;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author Chuck
// * @since 4/9/2021
// * @version 0.0.1
// *
// **/
//@Component
//@Slf4j
//public class AppRunner implements CommandLineRunner {
//    @Resource
//    @Setter
//    private BookRepository bookRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        log.info("......Fetching books");
//        log.info("id-1234---->" + bookRepository.getById(1234));
//        log.info("id-5678---->" + bookRepository.getById(5678));
//        log.info("id-9012---->" + bookRepository.getById(9012));
//    }
//
//}
