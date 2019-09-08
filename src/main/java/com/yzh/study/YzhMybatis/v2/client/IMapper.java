package com.yzh.study.YzhMybatis.v2.client;

import com.yzh.study.useOriginalMybatis.Entity;

public interface IMapper {

	Entity selectById(int id);

	//使用v2mybatis添加另一种查询,第一步：接口添加定义
	Entity selectByName(String name);

}
