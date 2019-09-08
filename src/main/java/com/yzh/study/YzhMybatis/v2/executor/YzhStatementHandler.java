package com.yzh.study.YzhMybatis.v2.executor;

import com.yzh.study.YzhMybatis.v2.mapping.MapperData;

import java.sql.*;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-05 16:08
 **/
public class YzhStatementHandler {

	public <T> T query(MapperData mapperData, Object params) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = mapperData.getSql();
		//1，得到Connection对象，
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://10.0.30.201:3306/yzh_db_test", "belle", "belle@belle");
			//2，通过Connection获取一个操作sql语句的对象Statement
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (Integer) params);
			//4，查询，返回的结果放入ResultSet对象中。
			resultSet = preparedStatement.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		YzhResultSetHandler resultSetHandler = new YzhResultSetHandler();
		return resultSetHandler.handleResultSet(resultSet,mapperData);
	}

}
