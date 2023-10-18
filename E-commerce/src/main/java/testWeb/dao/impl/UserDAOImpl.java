package testWeb.dao.impl;
import java.sql.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testWeb.dao.UserDAO;
import testWeb.db.DBConnect;
import testWeb.vo.TestInfo;
import testWeb.vo.UserInfo;

public class UserDAOImpl implements UserDAO {

	public int queryByUserInfo(UserInfo userinfo) throws Exception {
		int flag = 0;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;
        DBConnect dbc = null;

        // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            dbc = new DBConnect() ;
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1,userinfo.getUsername()) ;//把第一个值放到逗号后面的那个里面
            // 进行数据库查询操作
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                // 查询出内容，将其与用户提交的内容对比
                if(rs.getString("password").equals(userinfo.getPassword())){
                	flag = 1;
                }
            }
            rs.close() ;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            // 关闭数据库连接
            dbc.close() ;
        }
		return flag;
	}

	public int insert(UserInfo user) throws SQLException {
	    String sql = "insert into userinfo values(?,?,?,?,?)";
	    Connection connection = null;
	    PreparedStatement statement = null;
	    int flag = 1;
	    String sqlFind = "select * from userinfo where username=?";
	    PreparedStatement pstmt = null ;
        DBConnect dbc = null;

     // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            dbc = new DBConnect() ;
            pstmt = dbc.getConnection().prepareStatement(sqlFind) ;
            pstmt.setString(1,user.getUsername()) ;//把第一个值放到逗号后面的那个里面
            // 进行数据库查询操作
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                // 查询出内容，将其与用户提交的内容对比
                if(rs.getString("username").equals(user.getUsername())){
                	flag = 0;
                }
            }
            rs.close() ;
            pstmt.close() ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            // 关闭数据库连接
            dbc.close() ;
        }





	    if(flag == 1) {
	    try {

	        // 创建预编译的Statement
	        statement = DBConnect.getConnection().prepareStatement(sql);
	        // 设置参数
	        statement.setString(1, user.getUsername());
	        statement.setString(2, user.getPassword());
	        statement.setString(3, user.getEmail());
	        statement.setString(4, user.getName());
	        statement.setString(5, user.getTel());
	        statement.executeUpdate();



	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 关闭资源
	        if (statement != null) {
	            statement.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }
	}
	    return flag;
	}

	public void insertData(TestInfo testInfo) throws Exception{
		 String sql="insert into testinfo(date, success, route, username) values(?,?,?,?)";
	        PreparedStatement statement = null;
	        try {

	            //创建预编译的Statement
	            statement = DBConnect.getConnection().prepareStatement(sql);
	            //设置参数
	            statement.setString(1,testInfo.getDate());
	            statement.setString(2,testInfo.getSuccess());
	            statement.setString(3,testInfo.getRoute());
	            statement.setString(4,testInfo.getUsername());

	            statement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            statement.close();
				DBConnect.getConnection().close();
	        }
	}

}
