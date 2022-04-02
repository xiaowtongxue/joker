package com.service;

import com.entity.Employee;

/**
 * 用户登录 服务层组件接口
 * @author del
 */
public interface loginService {
    public Employee validateLogin(Employee emp);
}
