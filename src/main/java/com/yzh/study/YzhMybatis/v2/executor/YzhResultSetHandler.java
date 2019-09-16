package com.yzh.study.YzhMybatis.v2.executor;

import com.yzh.study.YzhMybatis.v2.mapping.MapperData;
import com.yzh.study.useOriginalMybatis.Entity;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-05 16:25
 **/
public class YzhResultSetHandler {

	public <T> T handleResultSet(ResultSet resultSet, MapperData mapperData) {

		Class returnType = mapperData.getReturnType();
		Object returnObject = null;
		try {
			//mybatis用DefaultObjectFactory封装了，定义了各种接口类的实现类 --》 new DefaultObjectFactory().create(Entity.class)
			returnObject = returnType.getDeclaredConstructor().newInstance();
			Field[] returnObjectField = returnType.getDeclaredFields();
			while (resultSet.next()) {
				for (Field field : returnObjectField) {
					setValue(field, resultSet, returnObject);
				}
			}
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | SQLException e) {
			e.printStackTrace();
		}
		return (T) returnObject;
	}

	private void setValue(Field field, ResultSet resultSet, Object obj)
			throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Object value = getResult(field, resultSet);
		if (value != null) {
			obj.getClass().getMethod("set" + capitalize(field.getName()), field.getType()).invoke(obj, value);
		}
	}

	/**
	 * 模拟typeHandler
	 * @return
	 */
	private Object getResult(Field field, ResultSet resultSet) throws SQLException {
		Class fieldType = field.getType();
		String fieldName = field.getName();
		Object value = null;
		//这里模拟的是typeHandler
		if (fieldType == Integer.class || fieldType == int.class) {
			value = resultSet.getInt(fieldName);
		} else if (fieldType == String.class) {
			value = resultSet.getString(fieldName);
		}
		return value;
	}

	private static String capitalize(String name) {
		char[] strArray = name.toCharArray();
		//如果是小写字母
		if (strArray[0] >= 97 && strArray[0] <= 122) {
			strArray[0] -= 32;
		}
		return String.valueOf(strArray);
	}

	public static void main(String[] args) {


		try {
			Object obj1 = new DefaultObjectFactory().create(Entity.class);
			Object obj2 = Entity.class.getDeclaredConstructor().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
