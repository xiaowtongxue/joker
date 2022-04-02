package com.dao;

import com.entity.Employee;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 登录操作 持久层组件实现类
 *
 * @author del
 */
public class loginDaoImpl implements loginDao {
    @Override
    public Employee validateLogin(Employee emp) {
        String sql = "SELECT ID,NAME,LOGINNAME,GENDER,BIRTH,ADDRESS,PHONE,ENTRYDATE,DEPID,DESCS FROM EMPLOYEE WHERE LOGINNAME = ? AND PASSWORD = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet set = null;
        Employee employee = null;
        conn = DBUtil.getConn();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getLoginname());
            ps.setString(2, emp.getPassword());
            set = ps.executeQuery();
            while (set.next()) {
                employee = new Employee();
                employee.setId(set.getString("id"));
                employee.setName(set.getString("name"));
                employee.setGender(set.getString("gender"));
                employee.setBirth(set.getDate("birth"));
                employee.setAddress(set.getString("address"));
                employee.setPhone(set.getString("phone"));
                employee.setDepid(set.getString("depid"));
                employee.setDescs(set.getString("descs"));
                employee.setEntrydate(set.getDate("entrydate"));
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
        return employee;
    }
}
