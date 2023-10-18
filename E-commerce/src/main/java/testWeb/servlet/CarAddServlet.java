package testWeb.servlet;

import testWeb.dao.ICarInfoDAO;
import testWeb.dao.impl.CarInfoDAOImpl;
import testWeb.vo.CarInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/caradd")
public class CarAddServlet extends HttpServlet {

    private ICarInfoDAO carInfoDAO = new CarInfoDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String carName = req.getParameter("carName");
        String carImg = req.getParameter("carImg");
        Object username = req.getSession().getAttribute("username");
        if (username != null && !"".equals(username)){
            try {
                carInfoDAO.addCar(new CarInfo(carName,carImg,username.toString()));
                resp.sendRedirect("./car");
            } catch (SQLException e) {
                resp.sendRedirect("./exceptions.jsp");
            }
        }


    }
}
