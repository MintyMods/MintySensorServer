package info.mintymods.mss.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.webapp.websocket.WebSocketChannel;
import info.mintymods.mss.webapp.websocket.WebSocketEvent;
import info.mintymods.mss.webapp.websocket.WebSocketInstruction;
import info.mintymods.utils.ProfillerUtils;

@Service
public class MsmEventEmittingService {

	private static final Logger log = LoggerFactory.getLogger(MsmEventEmittingService.class);
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	private final boolean debug = true;

	public void processResponse(final MsmMonitorResponse response) {
		emitReadings(response);
		if (debug) {
			log.info(String.format("@EventEmitterPolled# %d Sensors, %d Readings - %s", response.getSensors().size(), response.getReadings().size(),
					ProfillerUtils.getGarbageCollectionStats()));
		}
	}

	public void sendMessage(final WebSocketInstruction message) {
		messagingTemplate.convertAndSend(message.getChannel(), message);
	}

	private void emitReadings(final MsmMonitorResponse response) {
		final WebSocketEvent event = new WebSocketEvent(response);
		final WebSocketInstruction message = new WebSocketInstruction(event);
		message.setChannel(WebSocketChannel.CHANNEL_EVENTS);
		sendMessage(message);
	}
}
