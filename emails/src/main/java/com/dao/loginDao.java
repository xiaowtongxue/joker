package com.dao;

import com.entity.Employee;

/**
 * 登录操作 持久层组件接口
 * @author del
 */
public interface loginDao {
    public Employee validateLogin(Employee emp);
}
