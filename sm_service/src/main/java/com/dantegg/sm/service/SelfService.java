package com.dantegg.sm.service;

import com.dantegg.sm.entity.Staff;

public interface SelfService {

    Staff login(String account, String password);
    void  changePassword(Integer id, String password);
}
