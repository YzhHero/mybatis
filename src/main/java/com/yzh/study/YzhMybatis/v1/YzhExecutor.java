package com.yzh.study.YzhMybatis.v1;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-03 16:37
 **/
public interface YzhExecutor {
	<T> T selectOne(String sql,Object params);
}
