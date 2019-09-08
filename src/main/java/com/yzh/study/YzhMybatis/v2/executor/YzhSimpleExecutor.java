package com.yzh.study.YzhMybatis.v2.executor;

import com.yzh.study.YzhMybatis.v2.mapping.MapperData;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-03 20:29
 **/
public class YzhSimpleExecutor implements YzhExecutor {

	@Override
	public <T> T selectOne(MapperData mapperData, Object params) {
		YzhStatementHandler statementHandler = new YzhStatementHandler();
		return statementHandler.query(mapperData,params);
	}

}
