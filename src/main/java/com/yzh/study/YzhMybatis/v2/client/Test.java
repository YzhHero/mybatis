package com.yzh.study.YzhMybatis.v2.client;

import com.yzh.study.YzhMybatis.v2.executor.YzhSimpleExecutor;
import com.yzh.study.YzhMybatis.v2.mapping.MapperRegistory;
import com.yzh.study.YzhMybatis.v2.session.YzhConfiguration;
import com.yzh.study.YzhMybatis.v2.session.YzhSqlSession;
import com.yzh.study.useOriginalMybatis.Entity;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-04 11:03
 **/
public class Test {
	public static void main(String[] args) {
		YzhSqlSession yzhSqlSession =new YzhSqlSession(new YzhConfiguration());
		IMapper mapper = yzhSqlSession.getMapper(IMapper.class);
		Entity entity = mapper.selectById(1);
		System.out.println(entity.toString());
//		ClassLoader classLoader1 = YzhConfiguration.class.getClassLoader();
//		ClassLoader classLoader2 = IMapper.class.getClassLoader();
//		System.out.println(classLoader1.toString());
//		System.out.println(classLoader2.toString());
	}
}
