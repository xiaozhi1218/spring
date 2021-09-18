package com.itheima.service;

/**
 * 包名:com.itheima.service
 *
 * @author Leevi
 * 日期2020-11-12  10:54
 */
public interface AccountService {
    void transfer(String fromName, String toName, Double money);
}
