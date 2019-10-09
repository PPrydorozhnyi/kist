package com.peter.kist.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
