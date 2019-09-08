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

	@MessageMapping("/api.command")
	@SendTo(WebSocketConfiguration.API_CHANNEL)
	public WebSocketInstruction sendMessage(@Payload final WebSocketInstruction message) {
		if (WebSocketCommand.SENSORS == message.getCommand()) {
			service.sendSensors(message);
		} else if (WebSocketCommand.SENSOR_READINGS == message.getCommand()) {
			service.sendReadingsBySensor(message);
		} else if (WebSocketCommand.TYPE_READINGS == message.getCommand()) {
			service.sendReadingsByType(message);
		} else if (WebSocketCommand.TYPES == message.getCommand()) {
			service.sendTypes(message);
		} else if (WebSocketCommand.PING == message.getCommand()) {
			service.sendPong(message);
		}
		return message;
	}

	@MessageMapping("/api.register")
	@SendTo(WebSocketConfiguration.API_CHANNEL)
	public WebSocketInstruction addUser(@Payload final WebSocketInstruction message,
			final SimpMessageHeaderAccessor headerAccessor) {
		// headerAccessor.getSessionAttributes().put("client", message.getParameter("client"));
		return message;
	}
}
