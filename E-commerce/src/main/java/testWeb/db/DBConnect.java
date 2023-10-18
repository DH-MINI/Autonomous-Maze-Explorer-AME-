package testWeb.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/javawebdb" ;
    private static final String DBUSER = "root" ;
    private static final String DBPASSWORD = "13001236309" ;
    private static Connection conn = null ;

    // 取得数据库连接
    public static Connection getConnection(){
        if (conn == null) {
            try{
                Class.forName(DBDRIVER) ;
                conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return conn ;
    }

    // 关闭数据库连接
    public static void close(){
        //链接在Tomcat关闭的时候在关闭，频繁创建和关闭会降低系统性能
//        if (conn != null) {
//            try{
//                conn.close() ;
//            }catch (Exception e){ }
//        }

    }

}
