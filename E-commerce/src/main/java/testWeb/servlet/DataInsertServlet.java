package testWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testWeb.dao.impl.UserDAOImpl;
import testWeb.vo.TestInfo;

public class DataInsertServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String success = request.getParameter("success");
        String route = request.getParameter("route");
        String username = (String) request.getSession().getAttribute("username");
        if (username != null &&!"".equals(username)) {
            TestInfo testInfo = new TestInfo();
            testInfo.setDate(date);
            testInfo.setSuccess(success);
            testInfo.setRoute(route);
            testInfo.setUsername(username);


            try {
                UserDAOImpl userDAOImpl = new UserDAOImpl();
                userDAOImpl.insertData(testInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("./query.jsp");
        }else{
            response.sendRedirect("./exceptions.jsp");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
