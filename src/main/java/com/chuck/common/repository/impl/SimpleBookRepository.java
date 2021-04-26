//package com.chuck.common.repository.impl;
//
//import com.chuck.common.domain.Book;
//import com.chuck.common.repository.BookRepository;
//
//import org.springframework.stereotype.Component;
//
///**
// * @author Chuck
// * @since 4/9/2021
// * @version 0.0.1
// *
// **/
//@Component
//public class SimpleBookRepository implements BookRepository {
//
//    // @Cacheable
//    @Override
//    public Book getById(int id) {
//        mockSlowService();
//        return new Book(id, "mockBook", null);
//    }
//
//    private void mockSlowService() {
//        long time = 3000;
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            throw new IllegalStateException(e);
//        }
//    }
//}
