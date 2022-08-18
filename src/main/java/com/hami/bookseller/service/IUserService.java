package com.hami.bookseller.service;

import com.hami.bookseller.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUserName(String userName);

    void makeAdmin(String userName);
}
