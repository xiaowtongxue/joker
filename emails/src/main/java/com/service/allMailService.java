package com.service;

import com.entity.Employee;
import com.entity.InBox;

import java.util.List;

/**
 * 所有邮件 服务层组件接口
 */
public interface allMailService {
    /**
     * 查询所有邮件的方法
     * @param id 收件人id
     * @return 邮件集合
     */
    public List<InBox> queryAllMail(String id);

    /**
     * 查询所有员工姓名的方法
     *
     * @return 员工集合
     */
    public List<Employee> queryAllEmp();
}
