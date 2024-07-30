package com.webSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws") // socket 연결 url
				.setAllowedOrigins("*"); // CORS 허용 범위
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 메시지를 구독(수신)하는 요청 엔드포인트
		registry.enableSimpleBroker("/sub"); // 구독 url
		
		// 메시지를 발행(송신)하는 엔드포인트
		registry.setApplicationDestinationPrefixes("/pub"); // prefix 정의
	}
}
