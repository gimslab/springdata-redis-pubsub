package com.gimslab.redispubsub.springdataredispubsub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.redis.core.StringRedisTemplate

@SpringBootApplication
class SpringDataRedisPubSubApplication(
		stringRedisTemplate: StringRedisTemplate
) {

	init {
		println("HHHHHHHHHHHHHHHHHHHHHHHHHHH")
		println("HHHHHHHHHHHHHHHHHHHHHHHHHHH")
		println("HHHHHHHHHHHHHHHHHHHHHHHHHHH")

		stringRedisTemplate.convertAndSend("helloQueue", "worlworlworlworlworlworlworldddddddworld")

		println("+++ message sent")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringDataRedisPubSubApplication>(*args)

	while(true)
		Thread.sleep(100)
}
