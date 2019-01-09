package con.xrz.blog.servlet;

import con.xrz.blog.dao.ArticleDao;
import con.xrz.blog.dao.UserDao;
import con.xrz.blog.pojo.Article;
import con.xrz.blog.pojo.User;
import org.json.JSONObject;
//import com.alibaba.fastjson.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");//设置表单编码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        try
        {
            User byname =UserDao.get_userByName(((User) request.getSession().getAttribute("currentUser")).getName());
            int id = byname.getId();
            List<Article> byUserId = ArticleDao.get_article_ByUserId(id);
            String res = JSONObject.valueToString(byUserId);
//            System.out.println(res);
            out.print(res);

        }
        catch (Exception e)
        {
            out.print("error");
        }
    }
}
