<%@ page import="java.util.List" %>
<%@ page import="com.ftg.pojo.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工表</title>
</head>
<body>
<table BORDER="1">
    <tr>
        <td>工号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>学历</td>
        <td>入职日期</td>
        <td>操作</td>
    </tr>
    <%
        List list= (List) request.getAttribute("list");
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            Emp e = (Emp)list.get(i);

    %>
    <tr>
        <td><%=e.getEid()%></td>
        <td><%=e.getEname()%></td>
        <td><%=e.getSex()%></td>
        <td><%switch(e.getEdu()){
            case 1: {out.print("博士");};break;
            case 2: {out.print("硕士");};break;
            case 3: {out.print("本科");};break;
            case 4: {out.print("专科");};break;
            case 5: {out.print("高中");};break;
            case 6: {out.print("初中");};break;
        }%>
        </td>
        <td><%=e.getEmployed()%></td>
    <td><a href="./queryone?eid=<%=e.getEid()%>">修改</a>|<a href="./delemp?eid=<%=e.getEid()%>">删除</a> </td>
    </tr>

    <%

        }
    %>
</table>



</body>
</html>
