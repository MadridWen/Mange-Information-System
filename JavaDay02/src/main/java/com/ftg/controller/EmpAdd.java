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

@WebServlet("/addEmp")
public class EmpAdd extends HttpServlet {
    //实例化业务处理
    private EmpService empService = new EmpService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String eid = req.getParameter("eid");
        String ename = req.getParameter("ename");
        //打印
        System.out.println(eid+"-------"+ename);
        //
        Emp emp = new Emp();
        emp.setEid(Integer.parseInt(eid));//将字符串转换为int类型
        emp.setEname(ename);
        //调用增加方法
        try {
            empService.addEmp(emp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("404.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.sendRedirect("404.jsp");
        }
    }
}
