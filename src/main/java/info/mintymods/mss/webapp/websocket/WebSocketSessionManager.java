package info.mintymods.mss.webapp.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

public class WebSocketSessionManager {

	final static Map<String, WebSocketSession> routes = new HashMap<>();

	public static void registerSession(final StompHeaderAccessor headers) {
		final WebSocketSession route = new WebSocketSession(headers.getSessionId(), headers.getDestination());
		routes.put(route.getSessionId(), route);
	}

	public static void closeSession(final String session) {
		routes.remove(session);
	}
}
