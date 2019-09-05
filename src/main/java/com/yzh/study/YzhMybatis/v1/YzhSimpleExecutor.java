package com.yzh.study.YzhMybatis.v1;

import com.mysql.jdbc.Driver;
import com.yzh.study.useOriginalMybatis.Entity;

import java.sql.*;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-03 20:29
 **/
public class YzhSimpleExecutor implements YzhExecutor {

	@Override
	public <T> T selectOne(String sql, Object params) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//1，得到Connection对象，
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://10.0.30.201:3306/yzh_db_test", "belle", "belle@belle");
			//2，通过Connection获取一个操作sql语句的对象Statement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (Integer) params);
			//4，查询，返回的结果放入ResultSet对象中。
			resultSet = preparedStatement.executeQuery();
			Entity entity = new Entity();
			while (resultSet.next()) {
				entity.setId(resultSet.getInt(1));
				entity.setName(resultSet.getString(2));
				entity.setValue(resultSet.getString(3));
			}
			return (T) entity;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
