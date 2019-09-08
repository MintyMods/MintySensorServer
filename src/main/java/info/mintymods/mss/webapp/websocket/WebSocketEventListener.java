package info.mintymods.mss.webapp.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class WebSocketEventListener {

	private static final Logger log = LoggerFactory.getLogger(WebSocketEventListener.class);
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@EventListener
	public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
		log.debug("Received a new web socket connection " + event.getSource());
	}

	@EventListener
	public void handleSessionSubscribeEvent(final SessionSubscribeEvent event) {
		final StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage());
		WebSocketSessionManager.registerSession(headers);
	}

	@EventListener
	public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event) {
		final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		final String session = headerAccessor.getSessionId();
		if (session != null) {
			WebSocketSessionManager.closeSession(session);
			log.debug("Session Disconnected : " + session);
			// final WebSocketInstruction response = new WebSocketInstruction(session);
			// messagingTemplate.convertAndSend(WebSocketConfiguration.API_CHANNEL, response);
		}
	}
}