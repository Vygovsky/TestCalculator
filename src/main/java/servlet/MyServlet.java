package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/start")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /*  resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");*/
//or
        resp.setContentType("text/html; charset=utf-8");

        String name = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        System.out.println(name);
        System.out.println(lastName);


        PrintWriter writer = resp.getWriter();
        //writer.print("<h1>Hello Роман и " + name + " " + lastName + " doGet</h1> <br> Agane");
        writer.print("<h3>Профиль сотрудника</h3>");
        writer.print("Имя: " + name + "<br>");
        writer.print("Фимилия : " + name + "<br>");

        writer.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /*  resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");*/
//or
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String name = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        System.out.println(name);
        System.out.println(lastName);


        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Hello Роман и " + name + " " + lastName + " doPost</h1> <br> Agane");
        writer.close();
    }


/* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=resp.getWriter();
        pw.print("Hello world mather fack");

        req.setAttribute("name", " A A A A  I need help....");

        req.getRequestDispatcher("mypage.jsp").forward(req, resp);


    }
*/
}
