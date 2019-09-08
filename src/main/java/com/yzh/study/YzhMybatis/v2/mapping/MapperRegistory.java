package com.yzh.study.YzhMybatis.v2.mapping;

import com.yzh.study.useOriginalMybatis.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 模拟这是mapper.xml解析后的类
 * @author: HeroYang
 * @create: 2019-09-03 20:40
 **/
public class MapperRegistory {

	private static final Map<String, MapperData<Entity>> methodSqlMapping = new HashMap<>();

	//addMapper时
	static {
		//模拟mapper.xml扫描进来的步骤
		methodSqlMapping.put("com.yzh.study.YzhMybatis.v2.client.IMapper.selectById",
				new MapperData<>("select * from yzh_test where id =?", Entity.class)
		);
		//使用v2mybatis添加另一种查询,第二步：接口映射对接sql实现 TODO 这里要拓展参数
		methodSqlMapping.put("com.yzh.study.YzhMybatis.v2.client.IMapper.selectByName",
				new MapperData<>("select * from yzh_test where name =?", Entity.class)
		);
	}

	public MapperData getMapperData(String key){
		return methodSqlMapping.get(key);
	}

}
