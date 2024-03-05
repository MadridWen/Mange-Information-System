package com.ftg.service;

import com.ftg.DAO.EmpDAO;
import com.ftg.pojo.Emp;

import java.sql.SQLException;
import java.util.List;

public class EmpService {
    //实例化DAO包
    private EmpDAO empDAO = new EmpDAO();

    /**
     * 员工添加方法
     */
    public void addEmp(Emp emp) throws SQLException, ClassNotFoundException {
        //调用DAO包中的添加方法
        empDAO.addEmp(emp);
    }

    /**
     * 员工全查方法
     */
    public List<Emp> queryAllEmp() throws SQLException, ClassNotFoundException {
        //调用DAO包中的查询方法
        return empDAO.queryAllEmp();
    }

    /**
     * 员工单查方法
     */
    public Emp queryOne(Emp emp) throws SQLException, ClassNotFoundException {
        return empDAO.queryOne(emp);
    }

    /**
     * 员工删除方法
     */
    public void deleteEmp(Emp emp) throws SQLException, ClassNotFoundException {
        //调用DAO包中的删除方法
        empDAO.deleteEmp(emp);
    }

    /**
     * 员工修改方法
     */
    public void update(Emp emp) throws SQLException, ClassNotFoundException {
        //调用DAO包中的修改方法
        empDAO.update(emp);
    }
}
