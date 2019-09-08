package info.mintymods.mss.webapp.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	public static final String API_CHANNEL = "/api/";
	public static final String SENSOR_CHANNEL = "/sensors/";
	public static final String READING_CHANNEL = "/readings/";

	@Override
	public void configureMessageBroker(final MessageBrokerRegistry config) {
		config.enableSimpleBroker(API_CHANNEL, SENSOR_CHANNEL, READING_CHANNEL);
		config.setApplicationDestinationPrefixes("/app");
		// config.setUserDestinationPrefix(API_CHANNEL)
	}

	@Override
	public void registerStompEndpoints(final StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
	}
}
