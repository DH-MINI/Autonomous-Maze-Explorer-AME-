package testWeb.servlet;

import testWeb.file.TxtReader;
import testWeb.vo.TestTxtInfo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

/**
 * @ClassName CarTestTxtServlet
 * @Description 从txt文本文件中读取数据
 * @Author
 * @Date 2023/10/8 08:28
 * @Version V1.0
 **/
@WebServlet("/cartxt")
public class CarTestTxtServlet extends HttpServlet{

    public static final String FILE_PATH = "C:\\Users\\ljy13\\Desktop\\project\\testWeb(2)\\src\\main\\webapp\\WEB-INF\\test.txt";
    private TxtReader txtReader = new TxtReader();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            ServletContext context = req.getServletContext();
//            String realPath = context.getRealPath("WEB-INF/test.txt");

            List<TestTxtInfo> txtInfos = txtReader.read(FILE_PATH);
            req.setAttribute("txtInfos",txtInfos);
            req.getRequestDispatcher("./car-test.jsp").forward(req,resp);
            return;
        } catch (ParseException e) {
            System.out.println("文件解析失败，原因：" + e.getMessage());
            req.setAttribute("msg","文件解析失败，原因：" + e.getMessage());
            req.getRequestDispatcher("./exceptions.jsp").forward(req,resp);
        }


    }


}
