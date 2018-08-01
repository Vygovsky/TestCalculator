package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametersServlet")
public class ParametersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        String name = req.getParameter("user");
        HttpSession session = req.getSession();
        ServletContext context = req.getServletContext();
        if (name != " " && name == null) {
            session.setAttribute("user", name);
            context.setAttribute("user", name);
        }

        PrintWriter writer = resp.getWriter();
        writer.println("Request : " + name + "<br>");


    }
}
