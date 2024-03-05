package com.ftg.controller;

import com.ftg.pojo.Emp;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/utest")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        String info = "你好<br />";
        out.write(info);//输出字符串
        Gson gson = new Gson();//创建gson对象
        List<Emp> list = new ArrayList<>();//创建list集合
        Emp e1 = new Emp();//创建emp对象
        e1.setEid(1);
        e1.setEname("张三");
        Emp e2 = new Emp();
        e2.setEid(2);
        e2.setEname("李四");
        String s3 = gson.toJson(e1);
        String s4 = gson.toJson(e2);
        out.write(s3);
        out.write(s4);

    }
}
