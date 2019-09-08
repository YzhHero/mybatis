package com.yzh.study.YzhMybatis.v2.session;

import com.yzh.study.YzhMybatis.v2.binding.YzhMapperProxy;
import com.yzh.study.YzhMybatis.v2.mapping.MapperRegistory;
import lombok.Data;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-03 16:36
 **/
@Data
public class YzhConfiguration {

	private MapperRegistory mapperRegistory = new MapperRegistory();

	/**
	 * 尝试错误1：addMapper时，就想把mapper接口的动态代理生成，动态代理依赖sqlSession，而addMapper的正确实际应该是加载配置的时候，此时
	 * 	不应该生成sqlSeesion
	 */

	public <T> T getMapper(Class<T> clazz, YzhSqlSession yzhSqlSession) {
		return (T) Proxy
				.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz },
						new YzhMapperProxy(yzhSqlSession));
		//		return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new YzhMapperProxy(yzhSqlSession));
	}
}
