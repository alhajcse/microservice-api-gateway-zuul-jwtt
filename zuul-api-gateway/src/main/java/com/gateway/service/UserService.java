package com.gateway.service;

import com.gateway.model.User;

public interface UserService {

    void savUser(User user);


    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);




}
