package con.xrz.blog.servlet;

import con.xrz.blog.dao.UserDao;
import con.xrz.blog.pojo.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userdao = new UserDao();
        User user = userdao.login(username, password);
        if (user != null) {
            request.getSession().setAttribute("currentUser", user);
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("error.html");
        }
    }
}
