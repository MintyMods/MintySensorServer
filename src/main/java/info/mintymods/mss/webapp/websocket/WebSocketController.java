package info.mintymods.mss.webapp.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import info.mintymods.mss.webapp.service.MsmEventEmittingService;

@Controller
public class WebSocketController {

	@Autowired
	private MsmEventEmittingService service;

	@MessageMapping("/chat.sendMessage")
	@SendTo(WebSocketConfiguration.API_CHANNEL)
	public WebSocketInstruction sendMessage(@Payload final WebSocketInstruction message) {
		if ("sensors".equalsIgnoreCase(message.getContent())) {
			service.sendSensors();
		} else if ("debug=true".equalsIgnoreCase(message.getContent())) {
			service.setDebug(true);
		} else if ("debug=true".equalsIgnoreCase(message.getContent())) {
			service.setDebug(false);
		}
		return message;
	}

	@MessageMapping("/chat.addUser")
	@SendTo(WebSocketConfiguration.API_CHANNEL)
	public WebSocketInstruction addUser(@Payload final WebSocketInstruction chatMessage,
			final SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
}
