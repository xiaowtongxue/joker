package com.service;

import com.dao.loginDaoImpl;
import com.entity.Employee;

/**
 * 登录操作 服务层组件接口实现类
 * @author del
 */
public class loginServiceImpl implements loginService{
    @Override
    public Employee validateLogin(Employee emp) {
        return new loginDaoImpl().validateLogin(emp);
    }
}
