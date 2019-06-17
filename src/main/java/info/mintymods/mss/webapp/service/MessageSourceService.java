package info.mintymods.mss.webapp.service;

import info.mintymods.mss.webapp.enums.MessageKey;

public interface MessageSourceService {

	String getMessage(String key);

	String getMessage(String key, Object[] objects);

	String getMessage(MessageKey key);

	String getMessage(MessageKey key, Object[] objects);

}
