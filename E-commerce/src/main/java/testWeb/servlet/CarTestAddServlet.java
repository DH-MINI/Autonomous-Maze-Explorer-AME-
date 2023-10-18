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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/cartestadd")
public class CarTestAddServlet extends HttpServlet {

    ICarTestDAO carTestDAO = new CarTestDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarTestInfo carTestInfo = new CarTestInfo();

        String testDateStr = req.getParameter("testDate");
        String treasureNumStr = req.getParameter("treasureNum");
        String carIdStr = req.getParameter("carId");
        if (testDateStr != null && !"".equals(testDateStr)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = null;
            try {
                parse = simpleDateFormat.parse(testDateStr);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            carTestInfo.setCarTestDate(parse);
        }
        if (treasureNumStr != null && !"".equals(treasureNumStr)){
            int num = Integer.parseInt(treasureNumStr);
            carTestInfo.setTreasureNum(num);
        }
        if (carIdStr != null && !"".equals(carIdStr)){
            int id = Integer.parseInt(carIdStr);
            carTestInfo.setCarId(id);
        }
        try {
            carTestDAO.addCarTest(carTestInfo);
            req.setAttribute("carId",carTestInfo.getCarId());
            req.getRequestDispatcher("./cartest").forward(req,resp);
        } catch (SQLException e) {
            resp.sendRedirect("./exceptions.jsp");
        }

    }
}
