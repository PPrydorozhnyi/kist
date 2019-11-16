package com.peter.kist.service;

import com.peter.kist.model.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
