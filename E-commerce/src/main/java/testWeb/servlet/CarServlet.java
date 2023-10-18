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
import java.util.List;


@WebServlet("/car")
public class CarServlet extends HttpServlet {

    private ICarInfoDAO carInfoDAO = new CarInfoDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CarInfo> carInfoList = null;
        try {

            Object username = req.getSession().getAttribute("username");
            if (username != null && !"".equals(username)){
                //查询所有小车信息
                carInfoList = carInfoDAO.findCarInfoList(username.toString());
                req.setAttribute("carInfoList",carInfoList);
                req.getRequestDispatcher("./car.jsp").forward(req,resp);
            } else {
                resp.sendRedirect("./exceptions.jsp");
            }

        } catch (SQLException e) {
            resp.sendRedirect("./error.jsp");
        }


    }
}
