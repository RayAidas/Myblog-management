package con.xrz.blog.servlet;

import con.xrz.blog.dao.ArticleDao;
import con.xrz.blog.pojo.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Add_articleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int art_user_id=Integer.parseInt(request.getParameter("user_id"));
        String art_title=request.getParameter("title");
        String art_type=request.getParameter("type");
        String art_tag=request.getParameter("tag");
        String art_content=request.getParameter("content");
        String art_description=request.getParameter("description");
//        Article article=new Article();
//        article.setArt_title(art_title);
        ArticleDao articledao=new ArticleDao();
        articledao.addArticle(new Article(art_user_id,art_title,art_type,art_tag,art_description,art_content));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
