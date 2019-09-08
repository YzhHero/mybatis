package com.yzh.study.YzhMybatis.v2.mapping;

import java.util.Map;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-05 19:19
 **/
public class MapperData<T> {
	private String sql;
	private Class<T> returnType;

	public String getSql() {
		return sql;
	}

	public Class<T> getReturnType() {
		return returnType;
	}

	public MapperData(String sql, Class<T> returnType) {
		this.sql = sql;
		this.returnType = returnType;
	}
}
