package com.dao;

import com.entity.Employee;
import com.entity.InBox;

import java.util.List;

/**
 * 所有邮件进入 持久层组件接口
 *
 * @author del
 */
public interface allMailDao {
    /**
     * 查询所有邮件的方法
     *
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

    /**
     * 修改文件已读或者标为未读的方法
     * @param id 邮件id
     * @return 修改成功标识
     */
    public int updateCheckid(String id);
}
