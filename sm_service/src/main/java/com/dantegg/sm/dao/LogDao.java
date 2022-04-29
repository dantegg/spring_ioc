package com.dantegg.sm.dao;

import com.dantegg.sm.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dantegg
 */
@Repository("logDao")
public interface LogDao {
    void insert(Log log);
    List<Log> selectByType(String type);
}
