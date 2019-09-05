package com.yzh.study.YzhMybatis.v1;

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
		//这里假设只有一个Mapper.xml，并且被组装到MapperXml类中
		//是否namespace匹配
		if (method.getDeclaringClass().getName().equals(MapperXml.getNAMESPACE())){
			String sql = MapperXml.getMethodSqlMapping().get(method.getName());
			//params其实实际也是从MapperXml取的
			return yzhSqlSession.selectOne(sql,args[0]);
		}
		return method.invoke(this,args);
	}
}
