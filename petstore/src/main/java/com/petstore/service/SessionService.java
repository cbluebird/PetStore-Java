package com.petstore.service;

import javax.servlet.http.HttpSession;

public interface SessionService {
    Integer setUserSession(HttpSession session,Integer userid);
    Integer getUserSession(HttpSession session);
    Integer getSellerSession(HttpSession session);

    Integer getAdminSession(HttpSession session);
}
