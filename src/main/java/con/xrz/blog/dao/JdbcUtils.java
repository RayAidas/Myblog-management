package con.xrz.blog.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class JdbcUtils {

    private static List connCache = new ArrayList<Connection>();
    //注册驱动的工具类

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF8";
    //    useUnicode=true&characterEncoding=UTF8";
    private static final String USER = "root";
    private static final String PASSWORD = "xrz123";

    private static java.sql.Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获得数据库的连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //通过数据库的连接操作数据路，实现增删查改
            java.sql.Statement stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //获取连接对象
    public static Connection getCon() throws SQLException {
        Connection conn = null;

        conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);

        return conn;
    }

    //关闭的方法
    public static void close(Statement statement, Connection conn) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //关闭的方法
    public static void close(PreparedStatement preparedStatement, Connection conn, ResultSet resultSet) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
