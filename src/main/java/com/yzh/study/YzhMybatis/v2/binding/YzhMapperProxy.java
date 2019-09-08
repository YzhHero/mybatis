package com.yzh.study.YzhMybatis.v2.binding;

import com.yzh.study.YzhMybatis.v2.mapping.MapperData;
import com.yzh.study.YzhMybatis.v2.session.YzhConfiguration;
import com.yzh.study.YzhMybatis.v2.session.YzhSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: mapper的代理
 * @author: HeroYang
 * @create: 2019-09-03 16:48
 **/
public class YzhMapperProxy implements InvocationHandler {

	private YzhSqlSession yzhSqlSession;


	public YzhMapperProxy(YzhSqlSession yzhSqlSession) {
		this.yzhSqlSession = yzhSqlSession;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String namespace = method.getDeclaringClass().getName();
		//是否namespace匹配
		MapperData mapperData = yzhSqlSession.getYzhConfiguration().getMapperRegistory().
				getMapperData(namespace + "." + method.getName());
		if (mapperData != null) {
			return yzhSqlSession.selectOne(mapperData, args[0]);
		}
		return method.invoke(this, args);
	}
}
