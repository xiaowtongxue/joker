package com.entity;

import java.util.Date;

/**
 * 员工部门实体类
 */
public class Department {
    private String id; //主键标识
    private String name; //部门名称
         private String code;//部门代码
    private Date makeDate;//成立日期
      private String descs;//备注信息

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

}
