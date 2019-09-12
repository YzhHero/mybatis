package com.yzh.study.useOriginalMybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-09 05:59
 *	 mybatis插件源码分析：
 *		1、解析xml时，将配置的plugin类new出来实现，加到configuration的interceptorChain中
 *		【源码中在configuration new Executor,ParameterHandler,ResultSetHandler,StatementHandler（这里相当于mybatis自己
 *		定义的切点）后，都有interceptorChain.pluginAll】
 *	    2、	在mybatis执行 interceptorChain.pluginAll 时，会循环所有interceptor 对相应的Executor和handler执行层层代理，
 *	    	具体步骤为：
 *	     a、获取单个interceptor上的注解上的Signature数组，生成SignatureMap --》Map（注解定义的type的class，该class注解上定义的方法）
 *	     b、若相应的Executor和handler的所有接口中包含Signature数组中定义的class，则生成代理
 *
 *     实际@Intercepts注解的含义就是定义规定类（Executor,ParameterHandler,ResultSetHandler,StatementHandler） 的某个方法被拦截
 **/
@Intercepts({@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class })})
public class Plugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("这是更新前" + "-" + invocation.getMethod().getName() +
				"-" + String.valueOf(invocation.getArgs()));
		Object returnObject = invocation.proceed();
		System.out.println("这是更新后");
		return returnObject;
	}

	@Override
	public void setProperties(Properties properties) {

	}
}
