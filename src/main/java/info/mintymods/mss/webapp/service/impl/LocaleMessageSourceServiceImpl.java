package info.mintymods.mss.webapp.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import info.mintymods.mss.webapp.enums.MessageKey;
import info.mintymods.mss.webapp.service.MessageSourceService;

@Service
public class LocaleMessageSourceServiceImpl implements MessageSourceService {

	@Autowired
	private MessageSource messageSource;

	@Override
	public String getMessage(String key) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, null, locale);
	}

	@Override
	public String getMessage(String key, Object[] objects) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, objects, locale);
	}

	@Override
	public String getMessage(MessageKey key) {
		return getMessage(key.getKey());
	}

	@Override
	public String getMessage(MessageKey key, Object[] objects) {
		return getMessage(key.getKey(), objects);
	}
}
