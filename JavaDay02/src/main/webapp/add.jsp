<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加员工</title>
</head>
<body>
    <h1>员工添加</h1>
    <form action="./addEmp" method="post">
        <hr>
    <table>
        <tr>
            <td>员工编号</td>
            <td><input type="text" name="eid"></td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="ename"></td>
        </tr>
        <tr>
            <td>操作</td>
            <td><button>员工添加</button></td>
        </tr>
    </table>
    </form>
</body>
</html>
