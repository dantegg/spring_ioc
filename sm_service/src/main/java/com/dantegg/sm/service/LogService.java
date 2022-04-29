package com.dantegg.sm.service;

import com.dantegg.sm.entity.Log;

import java.util.List;

/**
 * @author dantegg
 */
public interface LogService {
    void addSystemLog(Log log);
    void addLoginLog(Log log);
    void addOperationLog(Log log);

    List<Log> getSystemLog();
    List<Log> getLoginLog();
    List<Log> getOperationLog();
}
