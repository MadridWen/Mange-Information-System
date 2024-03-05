package com.ftg.controller;

import com.ftg.pojo.Emp;
import com.ftg.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/delemp")
public class EmpDelete extends HttpServlet {
    EmpService empService = new EmpService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接员工编号
        int eid = Integer.parseInt(req.getParameter("eid"));
        Emp emp = new Emp();
        emp.setEid(eid);
        try {
            empService.deleteEmp(emp);
            resp.sendRedirect("./queryAll");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("./404.jsp");
        }


    }
}
