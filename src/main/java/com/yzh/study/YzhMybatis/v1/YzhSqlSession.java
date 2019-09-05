package com.yzh.study.YzhMybatis.v1;

/**
 * @description: v1版sqlsession
 * @author: HeroYang
 * @create: 2019-09-03 16:32
 **/
public class YzhSqlSession {

	//保存各种配置信息
	YzhConfiguration yzhConfiguration;
	//委派执行数据库操作
	YzhExecutor yzhExecutor;

	public YzhSqlSession(YzhConfiguration yzhConfiguration, YzhExecutor yzhExecutor) {
		this.yzhConfiguration = yzhConfiguration;
		this.yzhExecutor = yzhExecutor;
	}

	public <T> T selectOne(String sql,Object params) {
		return yzhExecutor.selectOne(sql,params);
	}

	public <T> T getMapper(Class<T> clazz) {
		return yzhConfiguration.getMapper(clazz,this);
	}

}
