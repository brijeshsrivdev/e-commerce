//package com.ecommerce.service;
//
//import com.ecommerce.entities.User;
//import com.ecommerce.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Transactional
//public class UserServiceImpl {
//    @Autowired
//    private UserRepository userRepository;
//
//    private static List<User> users = new ArrayList<>();
//
//    static {
//        users.add(new User("user1@gmail.com","user1"));
//        users.add(new User("user2@gmail.com","user2"));
//    }
//
//    public void saveInitialBatch(){
//        userRepository.save(users);
//    }
//}
