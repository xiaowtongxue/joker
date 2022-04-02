package com.service;

import com.entity.Employee;
import com.entity.InBox;
import com.dao.allMailDaoImpl;

import java.util.List;

/**
 * 所有邮件 服务层组件接口实现类
 */
public class allMailServiceImpl implements allMailService {
    /**
     * 查询所有邮件的方法
     *
     * @param id 收件人id
     * @return 邮件集合
     */
    @Override
    public List<InBox> queryAllMail(String id) {
        return new allMailDaoImpl().queryAllMail(id);
    }

    /**
     * 查询所有员工姓名的方法
     *
     * @return 员工集合
     */
    @Override
    public List<Employee> queryAllEmp() {
        return new allMailDaoImpl().queryAllEmp();
    }
}
