package com.ftg.util;
import java.sql.*;
import java.util.*;

public class DBUtil {
    //数据库访问地址
    public static final String URL = "jdbc:mysql://192.168.229.128:3306/hrberp?serverTimezone=UTC";
    //用户名
    public static final String USER = "root";
    //密码
    public static final String PASSWORD = "123456";
    /**
     * 查询
     * */
    public  static List<Map> queryExecute(String sql,Object... objects) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        List<Map> list=new ArrayList<>();
        //编译：预编译sql语句
        PreparedStatement ps=conn.prepareStatement(sql);
        if(objects.length>0){
            for(int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
        }
        //获得结果集信息
        ResultSet rs=ps.executeQuery();
        //挖掘
        ResultSetMetaData rsmd = rs.getMetaData();
        //获得列数
        int  cols = rsmd.getColumnCount();
        //遍历结果集信息
        while(rs.next()){
            Map map=new HashMap();
            for(int i=1;i<=cols;i++){
                map.put(rsmd.getColumnName(i),rs.getString(i));
            }
            //插入list
            list.add(map);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            DBUtil dao =new DBUtil();
            dao.updateExecute("insert into emp2(eno,ename)values(?,?)",1000,"吴宏达");

    }
    /**
     * 更新
     * **/
    public static void updateExecute(String sql,Object... objects) throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        List<Map> list=new ArrayList<>();
        //编译：预编译sql语句
        PreparedStatement ps=conn.prepareStatement(sql);
        if(objects.length>0){
            for(int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
        }
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
