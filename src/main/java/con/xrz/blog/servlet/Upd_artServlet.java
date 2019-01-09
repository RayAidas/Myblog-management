package con.xrz.blog.servlet;

import con.xrz.blog.dao.ArticleDao;
import con.xrz.blog.pojo.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Upd_artServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Integer art_id= Integer.valueOf(request.getParameter("id"));
        String art_title=request.getParameter("title");
        String art_type=request.getParameter("type");
        String art_tag=request.getParameter("tag");
        String art_content=request.getParameter("content");
        String art_description=request.getParameter("description");

        ArticleDao articledao=new ArticleDao();
        try {
            articledao.updateArticle(new Article(art_id,art_title,art_type,art_tag,art_description,art_content));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
