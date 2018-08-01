package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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
        //  String job = req.getParameter("job");
        String[] jobs = req.getParameterValues("job");
        String gender = req.getParameter("gender");
        if (gender == null)
            gender = "-";
        String age = req.getParameter("age18");
        if (age == null)
            age = "-";
        System.out.println(name);
        System.out.println(lastName);
        //System.out.println(job);
        System.out.println("Колличество ролей " + jobs.length);
        for (String job : jobs) {
            System.out.println(job + ",");
        }
        System.out.println();
        System.out.println(gender);
        System.out.println(age);


        PrintWriter writer = resp.getWriter();
        //writer.print("<h1>Hello Роман и " + name + " " + lastName + " doGet</h1> <br> Agane");
        writer.print("<h3>Профиль сотрудника</h3>");
        writer.print("Имя: " + name + "<br>");
        writer.print("Фимилия : " + lastName + "<br>");
       // writer.print("Професия : " + job + "<br>");
        writer.print("Професия : " + Arrays.deepToString(jobs) + "<br>");
        writer.print("Пол : " + gender + "<br>");
        writer.print("Старше 18 : " + age + "<br>");


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
