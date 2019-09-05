package com.yzh.study.YzhMybatis.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 假设这是一个mapper.xml解析后的类
 * @author: HeroYang
 * @create: 2019-09-03 20:40
 **/
public class MapperXml {
	private static final String NAMESPACE ="com.yzh.study.YzhMybatis.v1.IMapper";

	private static final Map<String,String> methodSqlMapping = new HashMap<>();

	static {
		methodSqlMapping.put("selectById","select * from yzh_test where id =?");
	}

	public static String getNAMESPACE() {
		return NAMESPACE;
	}

	public static Map<String, String> getMethodSqlMapping() {
		return methodSqlMapping;
	}
}
