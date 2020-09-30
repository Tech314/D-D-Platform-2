package com.tech314.DDDataService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.tech314.DDDataService.handler.CampaignSocketHandler;

@Configuration
@EnableWebSocket
public class CampaignSocketConfig implements WebSocketConfigurer {

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new CampaignSocketHandler(), "/campaign");
	}

}