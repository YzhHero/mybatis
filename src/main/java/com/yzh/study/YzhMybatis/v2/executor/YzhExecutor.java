package com.yzh.study.YzhMybatis.v2.executor;

import com.yzh.study.YzhMybatis.v2.mapping.MapperData;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-03 16:37
 **/
public interface YzhExecutor {
	<T> T selectOne(MapperData mapperData, Object params);
}
