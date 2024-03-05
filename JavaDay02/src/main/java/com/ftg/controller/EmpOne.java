package com.ftg.controller;

import com.ftg.pojo.Emp;
import com.ftg.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/queryone")
public class EmpOne extends HttpServlet {
    EmpService empService = new EmpService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询某一个员工
        int eid = Integer.parseInt(req.getParameter("eid"));
        Emp emp = new Emp();
        emp.setEid(eid);
        try {
            Emp one= empService.queryOne(emp);
            //进入修改界面
            req.setAttribute("emp",one);
            //转发
            req.getRequestDispatcher("./update.jsp").forward(req,resp);
            //resp.sendRedirect("./queryAll");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./404.jsp");
        }
    }
}
