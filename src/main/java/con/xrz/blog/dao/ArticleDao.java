package con.xrz.blog.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import con.xrz.blog.pojo.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ArticleDao extends Article {
    public void addArticle(Article article) {
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
            connection = JdbcUtils.getCon();

            String sql = " insert into articles(art_user_id,art_title,art_type,art_tag,art_description,art_content)values(?,?,?,?,?,?)";
            psmt = (PreparedStatement) connection.prepareStatement(sql);

            //运用实体对象进行参数赋值
            psmt.setString(1, String.valueOf(article.getArt_user_id()));
            psmt.setString(2, article.getArt_title());
            psmt.setString(3, article.getArt_type());
            psmt.setString(4, article.getArt_tag());
            psmt.setString(5, article.getArt_description());
            psmt.setString(6, article.getArt_content());
            psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtils.close(psmt, connection);
        }
    }

    public void updateArticle(Article article) throws SQLException {
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
            connection = JdbcUtils.getCon();
            String sql="" +
                    " update articles " +
                    " set art_title=?,art_type=?,art_content=?,art_description=?,art_tag=? " +
                    " where art_id=? ";
            psmt = (PreparedStatement) connection.prepareStatement(sql);

            psmt.setString(1, article.getArt_title());
            psmt.setString(2, article.getArt_type());
            psmt.setString(3, article.getArt_content());
            psmt.setString(4, article.getArt_description());
            psmt.setString(5, article.getArt_tag());
            psmt.setInt(6, article.getArt_id());
            psmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtils.close(psmt, connection);
        }

    }

    public void delArticle(Integer art_id) throws SQLException{
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
            connection = JdbcUtils.getCon();
            String sql="" +
                    " delete from articles " +
                    " where art_id=? ";
            psmt = (PreparedStatement) connection.prepareStatement(sql);

            psmt.setInt(1, art_id);
            psmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtils.close(psmt, connection);
        }
    }

    public static List<Article> get_article_ByUserId(Integer art_user_id) throws SQLException {
        Connection connection = null;
        PreparedStatement psmt = null;
//        List<Article> artList = new ArrayList<Article>();
        List artList = new ArrayList();
        connection = JdbcUtils.getCon();
        String sql = "select * From articles where art_user_id=?";
        try {
            psmt = (PreparedStatement) connection.prepareStatement(sql);
            psmt.setInt(1,art_user_id);
            ResultSet rs = psmt.executeQuery();
            Article article = null;

            while (rs.next()){

                article = new Article();
                article.setArt_id(rs.getInt("art_id"));
                article.setArt_user_id(rs.getInt("art_user_id"));
                article.setArt_title(rs.getString("art_title"));
                article.setArt_type(rs.getString("art_type"));
                article.setArt_tag(rs.getString("art_tag"));
                article.setArt_content(rs.getString("art_content"));
                article.setArt_cre_time(rs.getTimestamp("art_cre_time"));
                article.setArt_com_num(rs.getInt("art_com_num"));
                article.setArt_description(rs.getString("art_description"));
                article.setArt_hot_num(rs.getInt("art_hot_num"));
                article.setArt_like_num(rs.getInt("art_like_num"));
                article.setArt_view(rs.getInt("art_view"));
                article.setArt_img(rs.getString("art_img"));
                artList.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(psmt, connection);
        }
        return artList;
    }

    public Article get(){
        return null;
    }
}
