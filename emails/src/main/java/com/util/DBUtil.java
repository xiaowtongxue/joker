package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接池c3p0组件
 */
public class DBUtil {
    public static ComboPooledDataSource dataSource = null;
    public static Connection connection = null;

    static {
        dataSource = new ComboPooledDataSource();
        //四项核心配置
        dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        try {
            dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setUser("scott");
        dataSource.setPassword("tiger");
    }

    public static Connection getConn() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String sql = "select count(*) total from bank";
        String sql2 = "SELECT ID,NAME,LOGINNAME,GENDER,BIRTH,ADDRESS,PHONE,ENTRYDATE,DEPID,DESCS FROM EMPLOYEE ";
        try {
            PreparedStatement ps = getConn().prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("loginname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

