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
	@SendTo(WebSocketChannel.CHANNEL_API)
	public WebSocketInstruction sendMessage(@Payload final WebSocketInstruction message) {
		// if (WebSocketCommand.SENSORS == message.getCommand()) {
		// service.sendSensors(message);
		// } else if (WebSocketCommand.READINGS_BY_SENSOR == message.getCommand()) {
		// service.sendReadingsBySensor(message);
		// } else if (WebSocketCommand.READINGS_BY_TYPE == message.getCommand()) {
		// service.sendReadingsByType(message);
		// } else if (WebSocketCommand.TYPES == message.getCommand()) {
		// service.sendTypes(message);
		// } else if (WebSocketCommand.PING == message.getCommand()) {
		// service.sendPong(message);
		// }
		return message;
	}

	@MessageMapping("/api.events")
	@SendTo(WebSocketChannel.CHANNEL_EVENTS)
	public WebSocketInstruction addListener(@Payload final WebSocketInstruction message,
			final SimpMessageHeaderAccessor headerAccessor) {
		// service.sendReadings(message);
		return message;
	}

	@MessageMapping("/api.notification")
	@SendTo(WebSocketChannel.CHANNEL_NOTIFICATION)
	public WebSocketInstruction addNotificationEndPoint(@Payload final WebSocketInstruction message,
			final SimpMessageHeaderAccessor headerAccessor) {
		// @todo
		return message;
	}
}
