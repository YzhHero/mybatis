package com.yzh.study.useGeneratorAndSpring.actionTest;

import com.yzh.study.useGeneratorAndSpring.pojo.YzhTest;
import com.yzh.study.useGeneratorAndSpring.service.YzhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @description:
 * @author: HeroYang
 * @create: 2019-09-16 21:03
 **/
@Controller
public class YzhAction {

	@Autowired
	private YzhService yzhService;

	private static ApplicationContext getContextByxml(){
		return new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	private static ApplicationContext getContextByAnnotation(){
		return  new ClassPathXmlApplicationContext("spring/applicationContextAnnotation.xml");
	}

	public static void main(String[] args) {
//		ApplicationContext context =getContextByxml();
		/**
		 * xml依赖  MapperScannerConfigurer这个配置，使用
		 * org.mybatis.spring.mapper.MapperScannerConfigurer#postProcessBeanDefinitionRegistry(org.springframework.beans.factory.support.BeanDefinitionRegistry)
		 * 这个方法，将路径下独立的接口全部注册为 org.mybatis.spring.mapper.MapperFactoryBean,MapperFactoryBean的注入，
		 * 获取的是SqlSessionTemplate的getMapper，在mybatis执行到mapper代理委托 sqlsession执行增删改查时，由于传过去的sqlsession是
		 * SqlSessionTemplate，所以执行SqlSessionTemplate的增删改查，SqlSessionTemplate CRUD的方法都是使用的sqlSessionProxy，
		 * 此处代理作用是验证 ---- 此处事务是否交给了spring处理
		 * （1）根据是否有事务  创建sqlsession
		 * （2）根据是否有事务  commit sqlsession
		 */
		//TODO  annotation依赖@MapperScan注解，因为ImportBeanDefinitionRegistrar的关系，
		// 调用到org.mybatis.spring.annotation.MapperScannerRegistrar.registerBeanDefinitions(org.springframework.core.type.AnnotationMetadata, org.springframework.beans.factory.support.BeanDefinitionRegistry)
		ApplicationContext context =getContextByAnnotation();
		YzhAction yzhAction = (YzhAction) context.getBean("yzhAction");
		YzhTest yzhTest = yzhAction.yzhService.selectByPrimaryKey(4);
		System.out.println(yzhTest.toString());
	}
}
