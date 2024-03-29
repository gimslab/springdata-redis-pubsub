package com.gimslab.redispubsub.springdataredispubsub

import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Service

@Service
class RedisMessageListener : MessageListener {
	override fun onMessage(message: Message, pattern: ByteArray?) {
		println("Message received: $message")
	}
}