package testWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testWeb.dao.UserDAO;
import testWeb.dao.impl.UserDAOImpl;
import testWeb.vo.UserInfo;



public class UserRegisterServlet extends HttpServlet{
	

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String Email = request.getParameter("Email");
	        String name = request.getParameter("name");
	        String tel = request.getParameter("tel");

	        
	        UserInfo user = new UserInfo();
	        user.setUsername(username);
	        user.setPassword(password);
	        user.setEmail(Email);
	        user.setName(name);
	        user.setTel(tel);
	        
	        
	        int flag = 1;
	        try {
	        	 
	            UserDAOImpl userDAOImpl = new UserDAOImpl();
				flag=userDAOImpl.insert(user);
				
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        if (flag == 1) {
	            response.sendRedirect("./RegisterSuccess.jsp");
	        } else {
	            response.sendRedirect("./RegisterError.jsp");
	        }
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        this.doPost(request, response);
	    }
}
