package info.mintymods.mss.webapp.scheduling;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import info.mintymods.MintySensorServer;
import info.mintymods.jni.MsmResponseFactory;
import info.mintymods.mss.webapp.config.properties.MintyConfig;
import info.mintymods.mss.webapp.exception.MsmServiceProviderUnavailableException;
import info.mintymods.mss.webapp.service.MsmEventEmittingService;
import info.mintymods.mss.webapp.service.Notification;

public class MsmEventEmitterJob extends QuartzJobBean {

	private static final Logger log = LoggerFactory.getLogger(MsmEventEmitterJob.class);
	@Autowired
	private MsmEventEmittingService service;
	@Autowired
	MintyConfig config;

	@Override
	protected void executeInternal(final JobExecutionContext context) throws JobExecutionException {
		final MsmResponseFactory factory = new MsmResponseFactory(config);
		try {
			service.processResponse(factory.getResponse(MintySensorServer.getProviderType()));
		} catch (final MsmServiceProviderUnavailableException unavailableException) {
			Notification.sendError(unavailableException.getMessage());
			log.error(unavailableException.getMessage());
			log.warn("Service Provider Unavaliable - shutting down scheduler...");
			shutDownScheduler(context);
		}
	}

	private void shutDownScheduler(final JobExecutionContext context) {
		try {
			context.getScheduler().shutdown();
		} catch (final SchedulerException schedulerException) {
			log.error(schedulerException.getMessage(), schedulerException);
		}
	}
}