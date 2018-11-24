package com.Ben.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

/*
    实现DRUID连接池工具类
    返回数据库连接对象

     1. 读取自定义的properties配置文件
     2. 工厂类,创建DataSource接口实现类
 */
public class DruidUtils {
    //创建出DataSource接口类型的变量
    private static DataSource dataSource;

    //读取配置文件,运行一次
    static {
        try {
            //创建集合对象
            Properties prop = new Properties();
            //通过类的加载器获取字节输入流
            //获取本类的class文件对象->获取类的加载器,获取输入流
            InputStream in = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(in);
            //连接池对象的类,创建出DataSource接口实现类
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /*
      添加方法,直接返回DataSource接口实现类对象
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /*
       创建静态方法,返回数据库连接对象
     */
    public static Connection getConnection() throws SQLException {
       return dataSource.getConnection();
    }

    //实现释放资源方法
    public  static  void  close(Connection con, Statement stat, ResultSet rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stat!=null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
