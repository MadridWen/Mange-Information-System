package com.ftg.DAO;

import com.ftg.pojo.Emp;
import com.ftg.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpDAO {
    //实例化DBUtil工具类
    private DBUtil dbu = new DBUtil();
    //    员工添加方法
    public void addEmp(Emp emp) throws SQLException, ClassNotFoundException {
        //增加员工的sql语句
        String sql = "insert into employees values(?,?,?,?,?,?,?)";
        //传参对象集合
        dbu.updateExecute(sql,emp.getEid(),emp.getEname(),emp.getSex(),emp.getEdu(),emp.getEmployed(),emp.getBirthday(),emp.getSalary());
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Emp emp = new Emp();
//        emp.setEid(56);
//        emp.setEname("张三");
//        emp.setSex("男");
//        emp.setEdu(1);
//        emp.setEmployed("2019-12-12");
//        emp.setBirthday("1999-12-12");
//        EmpDAO empDAO = new EmpDAO();
//        empDAO.addEmp(emp);
        List<Emp> list = new EmpDAO().queryAllEmp();
//        for (Emp e:list){
//            System.out.println(e.getEid()+"\t"+e.getEname()+"\t"+e.getSex()+"\t"+e.getEdu()+"\t"+e.getEmployed()+"\t"+e.getBirthday()+"\t"+e.getSalary());
//        }
    }
    //    员工删除方法
    public void deleteEmp(Emp emp) throws SQLException, ClassNotFoundException {
        String sql = "delete from employees where eid = ?";
        dbu.updateExecute(sql,emp.getEid());
    }
    //    员工修改方法
    public void update(Emp emp) throws SQLException, ClassNotFoundException {
        //修改员工的sql语句
        String sql = "update employees set eid=?,ename=?,sex=?,edu=?,employed=?,Birthday=?,Salary=? where eid=?";
        //传参对象集合
        dbu.updateExecute(sql,emp.getEid(),emp.getEname(),emp.getSex(),emp.getEdu(),emp.getEmployed(),emp.getBirthday(),emp.getSalary(),emp.getEid());
    }
    //    员工单查方法
    public Emp queryOne(Emp emp) throws SQLException, ClassNotFoundException {
        //查询所有员工的sql语句
        String sql = "select * from employees where eid = ?";
        List<Map> list = dbu.queryExecute(sql, emp.getEid());
        Map m = list.get(0);
        emp.setEid(Integer.parseInt(m.get("eid").toString()));
        emp.setEname((String) m.get("ename"));
        emp.setSex((String) m.get("sex"));
        emp.setEdu(Integer.parseInt(m.get("edu").toString()));
        emp.setEmployed((String) m.get("employed"));
        emp.setBirthday((String) m.get("birthday"));
        emp.setSalary(Double.parseDouble(m.get("salary").toString()));
        return emp;

        }

    //    员工全查方法
    public List<Emp> queryAllEmp() throws SQLException, ClassNotFoundException {
        //查询所有员工的sql语句
        String sql = "select * from employees";
        List<Map> list = dbu.queryExecute(sql);//调用DBUtil工具类中的查询方法
        List<Emp> list2 = new ArrayList<>();//创建一个list集合
        //将list集合中的数据封装到Emp对象中
        for (Map m:list){
            Emp emp = new Emp();
            emp.setEid(Integer.parseInt(m.get("eid").toString()));
            emp.setEname((String) m.get("ename"));
            emp.setSex((String) m.get("sex"));
            emp.setEdu(Integer.parseInt(m.get("edu").toString()));
            emp.setEmployed((String) m.get("employed"));
            emp.setBirthday((String) m.get("birthday"));
            emp.setSalary(Double.parseDouble(m.get("salary").toString()));
            list2.add(emp);


        }

        return list2;
    }
}
