package com.gimslab.redispubsub.springdataredispubsub

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer

@Configuration
class SpringRedisConfig {

	@Bean
	fun connectionFactory(): LettuceConnectionFactory {
		return LettuceConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))
	}

//	@Bean
//	fun stringRedisTemplate(): StringRedisTemplate {
//		return StringRedisTemplate(connectionFactory())
//	}

//	@Bean
//	fun messageListener(): MessageListenerAdapter {
//		return MessageListenerAdapter(RedisMessageSubscriber())
//	}

	@Bean
	fun redisMessageListenerContainer():RedisMessageListenerContainer{
		val container = RedisMessageListenerContainer()
		container.setConnectionFactory(connectionFactory())
//		container.addMessageListener(messageListener(), topic())
		container.addMessageListener(RedisMessageListener(), topic())
		return container
	}

	@Bean
	fun topic(): ChannelTopic {
		return ChannelTopic("helloQueue")
	}
}