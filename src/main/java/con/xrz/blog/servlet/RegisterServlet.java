package con.xrz.blog.servlet;

import con.xrz.blog.dao.UserDao;
import con.xrz.blog.pojo.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("name");
        String password=request.getParameter("password");

        UserDao dao = new UserDao();
        Boolean isExist = dao.isExist(name);
        if (isExist==false){
            JOptionPane.showMessageDialog(null, "注册成功,点击确认按钮后跳转到登录界面!");
            response.sendRedirect("/login.html");
        }
        if (isExist==true){
            JOptionPane.showMessageDialog(null, "注册失败,请重新注册！");
            response.sendRedirect("/register.html");
        }

        User user=new User();
        user.setName(name);
        user.setPassword(password);
        UserDao userdao=new UserDao();
        userdao.addUser(new User(name,password));





    }
}

