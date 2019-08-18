package com.zhiyou.redis;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport{
	private JedisConnectionFactory jedisConnectionFactory;
	private RedisTemplate<String,String> redisTemplate;//redis操作模板
	private RedisCacheManager redisCacheManager;
	public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate,
			RedisCacheManager redisCacheManager) {
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}
	public RedisCacheConfig() {
		
	}
	public JedisConnectionFactory getJedisConnectionFactory() {
		return jedisConnectionFactory;
	}
	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}
	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}
	@Bean
	public  KeyGenerator customKeyGenerator() {
		
		return new KeyGenerator() {
			
			public Object generate(Object target, Method method, Object... params) {
				//获得StringBuilder对象
				StringBuilder sBuilder=new StringBuilder();
				sBuilder.append(target.getClass().getName());//获得传入对象的全限定名，接到StringBuilder
				sBuilder.append(method.getName());//获得传入方法的名称，接到StringBuilder
				for (Object object : params) {
					sBuilder.append(object.toString());//传入对象的内存地址，接到StringBuilder
				}
				return sBuilder.toString();
			}

	     };
	}
}
