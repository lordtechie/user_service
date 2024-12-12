package com.user.service;


import com.user.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    //fake user list

    List<User> list= List.of(
            new User(1311L,"Tejas Patil","840343433"),
            new User(1312L,"Digu Mali","454544"),
            new User(1314L,"Abhay Vade","545465")
    );


    @Override
    public User getUser(Long id) {
        return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }
}
