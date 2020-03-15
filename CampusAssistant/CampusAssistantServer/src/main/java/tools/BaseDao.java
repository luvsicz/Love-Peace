package tools;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * @param <T> 数据库的连接
 * @author Liu-Bamboo
 */

public abstract class BaseDao<T> {

	private static PreparedStatement pst;

	private static ResultSet rst;

	private static Connection conn;

	public static Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource datesouce = (DataSource) envCtx.lookup("jdbc/TestDataSource");
		conn = datesouce.getConnection();
		if (conn == null) {
			System.out.println("数据库连接失败");
		}
		return conn;
	}

	// 对结果集进行处理

	// 执行查询
	public static ResultSet excutce(String sql, Object param[]) throws Exception {

		conn = BaseDao.getConnection();
		pst = conn.prepareStatement(sql);

		if (param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				pst.setObject(i + 1, param[i]);
			}
			rst = pst.executeQuery();
		}
		return rst;
	}

	public static ResultSet excutce(String sql) throws Exception {
		conn = BaseDao.getConnection();
		pst = conn.prepareStatement(sql);
		rst = pst.executeQuery();
		return rst;
	}

	public static int doUpdate(String sql, Object param[]) throws Exception {
		int rs = 0;
		conn = BaseDao.getConnection();
		pst = conn.prepareStatement(sql);

		if (param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				pst.setObject(i + 1, param[i]);
			}
			rs = pst.executeUpdate();
		}

		return rs;
	}

	//对结果集进行处理
	public abstract List<T> resultSetToList(ResultSet rst) throws SQLException;

}
