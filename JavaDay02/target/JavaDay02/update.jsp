<%@ page import="com.ftg.pojo.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加员工</title>
</head>
<%
    //获得员工信息
    Emp emp = (Emp)request.getAttribute("emp");

%>
<body>
    <h1>员工添加</h1>
    <form action="./update" method="post">
        <hr>
    <table>
        <tr>
            <td>员工编号</td>
            <td><input type="text" name="eid" value="<%=emp.getEid()%>"></td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="ename" value="<%=emp.getEname()%>" ></td>
        </tr>
        <tr>
            <td>操作</td>
            <td><button>员工修改</button></td>
        </tr>
    </table>
    </form>
</body>
</html>
