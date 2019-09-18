package com.yzh.study.useGeneratorAndSpring.service;

import com.yzh.study.useGeneratorAndSpring.dao.YzhTestMapper;
import com.yzh.study.useGeneratorAndSpring.pojo.YzhTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-16 21:00
 **/
@Service
public class YzhService {
	@Autowired
	private YzhTestMapper yzhTestMapper;

	public int insert(YzhTest record){
		return  yzhTestMapper.insert(record);
	}

	@Transactional
	public YzhTest selectByPrimaryKey(Integer id){
		return yzhTestMapper.selectByPrimaryKey(id);
	}


}
