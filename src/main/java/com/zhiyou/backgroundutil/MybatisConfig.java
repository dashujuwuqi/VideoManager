package com.zhiyou.backgroundutil;

import java.util.Properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootConfiguration
public class MybatisConfig {
	@Bean
	public PageHelper pageHelper() {
		PageHelper p=new PageHelper();
		//创建一个属性文件对象，把实例化pagehelper需要的参数写进去
		Properties properties=new Properties();
		//设置页码
		properties.setProperty("offsetAspageNum", "true");
		//设置分页时候的会进行count查询求得总数
		properties.setProperty("rowBoundsWithCount", "true");
		//分页参数合理化
		properties.setProperty("reasonable", "true");
		p.setProperties(properties);
		return p;
	}
}
