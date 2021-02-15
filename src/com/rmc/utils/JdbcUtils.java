package com.rmc.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author rmcgo
 * @create 2020-11-05 19:48
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    //数据库连接池，是将connection放进threadlocal里的，以保证每个线程从连接池中获得的都是线程自己的connection
    //以此来实现事务控制
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static{
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null，说明获取连接失败。有值说明获取成功
     */
    public static Connection getConnection(){
        Connection conn = conns.get();
        if(conn == null){
            try {
                conn = dataSource.getConnection();//从数据库连接池中获取连接
                conns.set(conn);//保存到ThreadLocal对象中，供后面的jdbc操作使用
                conn.setAutoCommit(false);//设置为手动管理
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;

    }


    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection conn = conns.get();
        if (conn != null){//如果不等于null，说明之前使用过连接，操作过数据库
            try {
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则就会出错。（因为Tomcat服务器使用了线程池技术）
        conns.remove();

    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection conn = conns.get();
        if (conn != null){//如果不等于null，说明之前使用过连接，操作过数据库
            try {
                conn.rollback();//回滚事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally{
                try {
                    conn.setAutoCommit(true);
                    conn.close();//关闭连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则就会出错。（因为Tomcat服务器使用了线程池技术）
        conns.remove();
    }












    /**
     * 关闭连接，放回数据库连接池
     * @param conn
    public static void close(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }*/

}
