package com.yzh.study.useGeneratorAndSpring.conf;

import lombok.val;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-17 17:00
 **/
@Configuration
@MapperScan(basePackages = "com.yzh.study.useGeneratorAndSpring.dao")
public class MyBatisConfig {

	@Autowired
	@Qualifier("dataSource")
 	public DataSource dataSource;

	@Bean(name ="sqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
//		ResourceLoader resolver = new PathMatchingResourcePatternResolver();
//		 ;
		sqlSessionFactoryBean.setMapperLocations(new ClassPathXmlApplicationContext().getResource("classpath:mappers/YzhTestMapper.xml"));
		SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
		return factory;
	}

}
