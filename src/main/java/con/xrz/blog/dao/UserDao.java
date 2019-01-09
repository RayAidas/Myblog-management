package con.xrz.blog.dao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import con.xrz.blog.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import static con.xrz.blog.dao.JdbcUtils.close;


public class UserDao {
    //数据库连接对象
    public User login(String username, String password) {
        User u = null;
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet resultSet = null;

        //赋值
        try {

            connection = JdbcUtils.getCon();
            //静态sql语句
            String sql = "select * from user where name=? and password=?";
            psmt = (PreparedStatement) connection.prepareStatement(sql);
            psmt.setString(1, username);
            psmt.setString(2, password);
            resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                u = new User();
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
                System.out.println("登录成功！");
                return u;
            } else {
                System.out.println("用户名或者密码错误！");
                return null;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(psmt, connection);
        }
        return u;

    }

    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
            connection = JdbcUtils.getCon();

            String sql = " insert into user(name,password,level,email)values(?,?,?,?)";
            psmt = (PreparedStatement) connection.prepareStatement(sql);

            //运用实体对象进行参数赋值
            psmt.setString(1, user.getName());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getLevel());
            psmt.setString(4, user.getEmail());
            psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtils.close(psmt, connection);
        }
    }

    public void updateUser(){

    }

    public Boolean isExist(String username) {
        try {
            Connection connection = JdbcUtils.getCon();
            String sql = "select exists (select id from user where name=? limit 1)";
            PreparedStatement psmt = (PreparedStatement) connection.prepareStatement(sql);
            psmt.setString(1, username);
            ResultSet resultSet = psmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBoolean(1);
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("sql execute exception! ");
            e.printStackTrace();
            return false;
        }
    }

    public static User get_userByName(String user_name) throws SQLException {
        User user = null;
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet resultSet = null;
        connection = JdbcUtils.getCon();
        String sql = "SELECT * FROM user WHERE name = ?";
        try {
            psmt = (PreparedStatement) connection.prepareStatement(sql);
            psmt.setString(1, user_name);
            resultSet = psmt.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(psmt, connection);
        }
        return user;
    }

    //通过ID查找用户（只含有基本信息）;
    public static User get_user_ById(Integer id) throws SQLException {
        User user = null;
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet resultSet = null;
        connection = JdbcUtils.getCon();
        try {
            String sql = "SELECT * FROM user WHERE id = ?";
            psmt = (PreparedStatement) connection.prepareStatement(sql);
            psmt.setInt(1, id);
            resultSet = psmt.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(psmt, connection);
        }
        return user;
    }

    //通过用户名查找对应用户实体类List（只含基本信息）;
//    public static List<User> get_userList_ById(Integer user_id, String select, String where) throws SQLException {
//        List<User> userList = new ArrayList<User>();
//        Connection connection = null;
//        PreparedStatement psmt = null;
//        ResultSet resultSet = null;
//        connection = JdbcUtils.getCon();
//        try {
//            StringBuilder sb = new StringBuilder();
//            sb.append("SELECT " + select + " FROM user");
//            sb.append(" WHERE " + where + " =?");
//            psmt = (PreparedStatement) connection.prepareStatement(sb.toString());
//            psmt.setInt(1, user_id);
//            ResultSet rs = psmt.executeQuery();
//            User user = null;
//            while (rs.next()) {
//                user = new User(get_user_ById(rs.getInt(select)));
//                userList.add(user);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            close(psmt, connection);
//        }
//        return userList;
//    }
}



