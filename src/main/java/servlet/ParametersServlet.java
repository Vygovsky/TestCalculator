package servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/parametersServlet", loadOnStartup = 0)
public class ParametersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        String user = req.getParameter("user");
        HttpSession session = req.getSession();
        ServletContext context = req.getServletContext();
        if (user != " " && user != null) {
            session.setAttribute("user", user);
            context.setAttribute("user", user);
        }
        session.setMaxInactiveInterval(5);
        PrintWriter writer = resp.getWriter();
        writer.println("Request : " + user + "<br>");
        writer.println("Parameter session : " + session.getAttribute("user") + "</br>");
        writer.println("Parameter context : " + context.getAttribute("user") + "</br>");
        writer.close();

        writer.print("<a href='http://localhost:8080'>Назад<a/><br>");


    }
}
