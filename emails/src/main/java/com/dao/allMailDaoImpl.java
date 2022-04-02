package com.dao;

import com.entity.Employee;
import com.entity.InBox;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 所有邮件进入 持久层组件接口实现类
 *
 * @author del
 */
public class allMailDaoImpl implements allMailDao {

    /**
     * 查询该登录员工所有邮件的方法
     *
     * @param id 员工id
     * @return 邮件集合
     */
    @Override
    public List<InBox> queryAllMail(String id) {
        String sql = "SELECT * FROM INBOX WHERE RECEIVEID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet set = null;
        List<InBox> mailList = new ArrayList<InBox>();
        conn = DBUtil.getConn();
        InBox inbox = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            set = ps.executeQuery();
            while (set.next()) {
                inbox = new InBox();
                inbox.setTitle(set.getString("title"));
                inbox.setSenderid(set.getString("senderid"));
                inbox.setCheckid(set.getString("checkid"));
                inbox.setSendtime(set.getDate("sendtime"));
                inbox.setReceiveid(set.getString("receiveid"));
                inbox.setContent(set.getString("content"));
                inbox.setReply(set.getInt("reply"));
                inbox.setDeleted(set.getInt("deleted"));
                inbox.setId(set.getString("id"));
                mailList.add(inbox);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mailList;
    }

    /**
     * 查询所有员工姓名的方法
     *
     * @return 员工集合
     */
    @Override
    public List<Employee> queryAllEmp() {
        String sql = "SELECT * FROM EMPLOYEE";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet set = null;
        Employee emp = new Employee();
        List<Employee> employeeList = new ArrayList<>();
        conn = DBUtil.getConn();
        try {
            ps = conn.prepareStatement(sql);
            set = ps.executeQuery();
            while (set.next()) {
                emp = new Employee();
                emp.setId(set.getString("id"));
                emp.setName(set.getString("name"));
                employeeList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }

    /**
     * 修改文件已读或者标为未读的方法
     *
     * @param id 邮件id
     * @return 修改成功标识
     */
    @Override
    public int updateCheckid(String id) {
        //成功标识
        int flag;
        //是否已读标识
        String checkid;
        String sql0 = "SELECT CHECKID FROM INBOX";
        String sql1 = "UPDATE INBOX SET CHECKID = ? WHERE ID = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DBUtil.getConn();
        return 1;
    }


}
