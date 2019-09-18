package com.yzh.study.useGeneratorAndSpring.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-17 17:04
 **/
@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {
	@Value("${driver}")
	private String driver;

	@Value("${url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${password}")
	private String password;

	@Bean("dataSource")
	public DataSource getDataSource() throws Exception{
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
