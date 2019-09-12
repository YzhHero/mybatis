package com.yzh.study.useOriginalMybatis;

import lombok.Data;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-08-27 11:30
 **/
@Data
public class Entity {

	public Entity() {
	}

	public Entity(int id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public Entity(String name, String value) {
		this.name = name;
		this.value = value;
	}

	private int id;

	private String name;

	private String value;
}
