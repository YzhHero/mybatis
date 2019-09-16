package com.yzh.study.useOriginalMybatis;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-08-27 11:25
 **/
public class TestMybatis {

	public static SqlSessionFactory getSqlSessionFactoryWithXml(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	public static SqlSessionFactory getSqlSessionFactoryWithCode(){
		PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
		Properties properties = new Properties();
		properties.setProperty("driver","com.mysql.jdbc.Driver");
		properties.setProperty("url","jdbc:mysql://10.0.30.201:3306/yzh_db_test");
		properties.setProperty("username","belle");
		properties.setProperty("password","belle@belle");
		pooledDataSourceFactory.setProperties(properties);
		DataSource dataSource = pooledDataSourceFactory.getDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		/**
		 * mybatis默认加载com/yzh/study/useMybatis下的xml，但在idea中xml不跟随一起编译
		 */
		configuration.addMapper(Mapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		return sqlSessionFactory;
	}


	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactoryWithXml();
//		SqlSessionFactory sqlSessionFactory = getSqlSessionFactoryWithCode();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Mapper mapper = sqlSession.getMapper(Mapper.class);
//		Entity entity = new Entity("test1","test1");
//		mapper.insert(entity);
		PageHelper.startPage(2, 2);
		List<Entity> list = mapper.select();
		for (Entity entity1 : list) {
			System.out.println(entity1.toString());
		}
		sqlSession.commit();
		if (sqlSession!=null){
			sqlSession.close();
		}
	}
}
