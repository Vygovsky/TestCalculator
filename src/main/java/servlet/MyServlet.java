package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* PrintWriter pw=resp.getWriter();
        pw.print("Hello world mather fack");*/
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);


    }

}
