package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@WebServlet("/user")
public class GetPost extends HttpServlet {
 //   private static final long serialNumb = 1L;
    private Map<Integer, String> users = new ConcurrentHashMap<>();
    private AtomicInteger atomicInteger;

    @Override
    public void init() throws ServletException {
        super.init();
        users.put(1, "Vase");
        users.put(2, "Kirril");
        users.put(3, "Roza");
        atomicInteger = new AtomicInteger(3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        /*Integer id = Integer.parseInt(req.getParameter("id"));
        String user = users.get(id);
        if (user == null) {
           user = " ";

        }*/
        List<String> userList = new ArrayList(users.values());
        req.setAttribute("users", userList);
        //resp.setContentType("text/html; charset=utf-8");
       /* PrintWriter writer = resp.getWriter();
        writer.println("<h3>User :" + user + " </h3><br>");
        //  writer.println("<a href='http://localhost:8080/user.html'>Back</a>");
        writer.close();*/
        RequestDispatcher dispatcher = req.getRequestDispatcher("user.jsp");
        dispatcher.forward(req, resp);


        // http://localhost:8080/user.html
        //<a href='javascript:history'.back();>Back</a>
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer id = null;
        if (!users.containsValue(name)) {
            id = atomicInteger.incrementAndGet();
            users.put(id, name);
        }

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (id == null) {
            writer.println("<h3>User " + name + " has</h3>");
        } else {
            writer.println("<h3> We create" + name + "is id= " + atomicInteger.get() + "</h3>");

        }
        writer.println("<br>");
        writer.println("<a href='http://localhost:8080/test'>На главную</a>");
        writer.close();
    }
}
