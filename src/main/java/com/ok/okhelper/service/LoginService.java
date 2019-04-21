package com.ok.okhelper.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    boolean loginValidate(String userName, String password);

    boolean loginStateValidate(HttpServletRequest request);
}
