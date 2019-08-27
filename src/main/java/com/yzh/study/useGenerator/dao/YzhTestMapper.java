package com.yzh.study.useGenerator.dao;

import com.yzh.study.useGenerator.pojo.YzhTest;

public interface YzhTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YzhTest record);

    int insertSelective(YzhTest record);

    YzhTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YzhTest record);

    int updateByPrimaryKey(YzhTest record);
}