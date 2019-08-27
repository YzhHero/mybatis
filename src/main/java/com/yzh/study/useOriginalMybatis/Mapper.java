package com.yzh.study.useOriginalMybatis;

import java.util.List;

public interface Mapper {
//	@Select("select * from yzh_test where id = 1")
	public List<Entity> select();

	public int insert(Entity entity);

}
