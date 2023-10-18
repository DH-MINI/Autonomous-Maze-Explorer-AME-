package testWeb.servlet;

import testWeb.dao.ICarTestDAO;
import testWeb.dao.impl.CarTestDAOImpl;
import testWeb.vo.CarTestInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/cartest")
public class CarTestServlet extends HttpServlet {

    private ICarTestDAO carTestDAO = new CarTestDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("carId");
        if (carId!=null) {

            try {
                CarTestInfo carTestInfo = carTestDAO.findCarTestInfoByCarId(Integer.parseInt(carId));

                req.setAttribute("carTestInfo",carTestInfo);
                req.getRequestDispatcher("./car-test.jsp").forward(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else{
            resp.sendRedirect("./exceptions.jsp");
        }

    }
}
