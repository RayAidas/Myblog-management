package con.xrz.blog.servlet;

import con.xrz.blog.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        UserDao dao = new UserDao();
        Boolean isExist = dao.isExist(name);
        System.out.println("user check - " + name + ": " + isExist);
        resp.getWriter().print(isExist.toString());
        resp.getWriter().flush();
    }
}
