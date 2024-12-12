package com.user.service;

import org.springframework.stereotype.Component;


public interface UserService {

    public <User> com.user.entity.User getUser (Long id);

}
