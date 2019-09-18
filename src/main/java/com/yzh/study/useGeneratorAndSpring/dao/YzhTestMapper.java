package com.yzh.study.useGeneratorAndSpring.dao;

import com.yzh.study.useGeneratorAndSpring.pojo.YzhTest;

public interface YzhTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YzhTest record);

    int insertSelective(YzhTest record);

    YzhTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YzhTest record);

    int updateByPrimaryKey(YzhTest record);
}