package com.dantegg.sm.dao;


import com.dantegg.sm.entity.Staff;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
public interface SelfDao {

    Staff selectByAccount(String account);
}
