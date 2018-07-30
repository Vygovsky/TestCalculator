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

@WebServlet("/parameter")
public class ParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = req.getParameter("user");
        HttpSession session = req.getSession();
        ServletContext context = getServletContext();
        if (user != " " && user != null) {
            session.setAttribute("user", user);
            context.setAttribute("user", user);

        }
        /*resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();
        writer.println("Request parameter :" + user + "<br>");
        writer.println("Session parameter :" + session.getAttribute("user") + "<br>");
        writer.println("Context parameter :" + context.getAttribute("user") + "<br>");
        //  writer.println("<a href=");
        writer.close();
        System.out.println("Session time :" + session.getMaxInactiveInterval());*/


    }
}
