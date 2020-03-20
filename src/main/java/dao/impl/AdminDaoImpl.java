package dao.impl;

import dao.AdminDao;
import dao.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl extends BaseDao implements AdminDao {

    @Override
    public int login(String name, String pwd) {
        String sql = "SELECT COUNT(*) FROM Admin WHERE name=? AND `pwd`=?";
        Object[] param = { name, pwd };

        ResultSet rs = super.executeQuery(sql, param);
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally {
            super.closeAll(rs, pstmt, con);
        }
        return count;
    }
}
