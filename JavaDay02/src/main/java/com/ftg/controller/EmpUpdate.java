package com.ftg.controller;

import com.ftg.pojo.Emp;
import com.ftg.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class EmpUpdate extends HttpServlet {
    private EmpService empService = new EmpService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //实例化业务处理
        //转码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String eid = req.getParameter("eid");
        String ename = req.getParameter("ename");
        //打印
        System.out.println(eid + "-------" + ename);

        //调用增加方法
        try {
            //来一个员工对象
            Emp emp = new Emp();
            emp.setEid(Integer.parseInt(eid));//将字符串转换为int类型
            Emp one = empService.queryOne(emp);
            one.setEid(Integer.parseInt(eid));
            one.setEname(ename);
            empService.update(emp);
            resp.sendRedirect("./queryAll");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("404.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.sendRedirect("404.jsp");
        }
    }
}
