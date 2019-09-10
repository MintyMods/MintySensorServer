package info.mintymods.mss.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import info.mintymods.mss.webapp.websocket.WebSocketChannel;
import info.mintymods.mss.webapp.websocket.WebSocketInstruction;

@Service
public class Notification {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	public void sendMessage(final WebSocketInstruction message) {
		messagingTemplate.convertAndSend(WebSocketChannel.CHANNEL_NOTIFICATION, message);
	}

	public static void sendError(final String message) {
		// TODO Auto-generated method stub
	}
}
