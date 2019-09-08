package com.yzh.study.YzhMybatis.v2.session;

import com.yzh.study.YzhMybatis.v2.executor.YzhExecutor;
import com.yzh.study.YzhMybatis.v2.executor.YzhSimpleExecutor;
import com.yzh.study.YzhMybatis.v2.mapping.MapperData;

import java.util.SimpleTimeZone;

/**
 * @description: v1版sqlsession
 * @author: HeroYang
 * @create: 2019-09-03 16:32
 **/
public class YzhSqlSession {

	//保存各种配置信息
	private YzhConfiguration yzhConfiguration;
	//委派执行数据库操作
	private YzhExecutor yzhExecutor = new YzhSimpleExecutor();

	public YzhSqlSession(YzhConfiguration yzhConfiguration) {
		this.yzhConfiguration = yzhConfiguration;
	}

	public YzhConfiguration getYzhConfiguration() {
		return yzhConfiguration;
	}

	public <T> T selectOne(MapperData mapperData,Object params) {
		return yzhExecutor.selectOne(mapperData,params);
	}

	public <T> T getMapper(Class<T> clazz) {
		return yzhConfiguration.getMapper(clazz,this);
	}

}
