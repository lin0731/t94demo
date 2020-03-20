package dao;

import java.sql.*;

public class BaseDao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://114.215.43.108:3306/t94?useUnicode=true&characterEncoding=utf-8";
    private String user = "root";
    private String pwd = "root";

    public Connection con;
    public PreparedStatement pstmt;

    /**
     * 获取连接方法
     *
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName(driver);
            if (con == null) {
                con = DriverManager.getConnection(url, user, pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    /**
     * 增删改操作
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object[] params) {
        int count = 0;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll(null, pstmt, con);
        }
        return count;
    }

    public ResultSet executeQuery(String sql, Object[] params) {
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 关闭资源
     *
     * @param rs
     * @param pstmt
     * @param con
     */
    public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
