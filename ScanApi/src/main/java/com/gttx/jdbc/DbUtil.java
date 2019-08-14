package com.gttx.jdbc;

import com.gttx.entity.Task;

import java.sql.*;

/**
 * Created by setsunayang on 2019-08-14
 */
public class DbUtil {
    public static Task getTask(){
        Task task = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(DataBase.JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DataBase.DB_URL,DataBase.USER,DataBase.PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM ";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){

            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return task;
    }
}
