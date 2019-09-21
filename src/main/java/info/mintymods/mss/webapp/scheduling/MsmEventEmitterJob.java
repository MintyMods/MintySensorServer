package info.mintymods.mss.webapp.scheduling;

import java.util.Date;
import java.util.Optional;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.QuartzJobBean;

import info.mintymods.MintySensorServer;
import info.mintymods.jni.MsmResponseFactory;
import info.mintymods.msm.MsmMonitorResponse;
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
	@Autowired
	MsmResponseFactory factory;
	@Autowired
	@Qualifier("eventEmitterFactoryBean")
	private Scheduler scheduler;

	@Override
	protected void executeInternal(final JobExecutionContext context) throws JobExecutionException {
		try {
			MsmMonitorResponse response = factory.getResponse(MintySensorServer.getProviderType());
			adjustPollingIntervalToMatchServiceProvider(context, response);
			service.processResponse(response);
		} catch (final MsmServiceProviderUnavailableException unavailableException) {
			Notification.sendError(unavailableException.getMessage());
			log.warn("Service Provider Unavaliable - shutting down scheduler...");
			log.error(unavailableException.getMessage());
			shutDownScheduler(context);
		}
	}

	private void adjustPollingIntervalToMatchServiceProvider(final JobExecutionContext context, MsmMonitorResponse response) {
		Optional<SimpleTriggerImpl> mutableTrigger = Optional.ofNullable(context)
				.map(JobExecutionContext::getTrigger)
				.filter(SimpleTriggerImpl.class::isInstance)
				.map(SimpleTriggerImpl.class::cast);
		try {
			if (mutableTrigger.isPresent()) {
				SimpleTriggerImpl trigger = mutableTrigger.get();
				trigger.setStartTime(getNextTriggerTime(response.getPolling_period()));
				scheduler.rescheduleJob(trigger.getKey(), trigger);
			}
		} catch (SchedulerException e) {
			log.error("Failed to match service providers poll interval", e);
		}
	}

	private Date getNextTriggerTime(Long period) {
		return new Date(System.currentTimeMillis() + period);
	}

	private void shutDownScheduler(final JobExecutionContext context) {
		try {
			scheduler.shutdown();
		} catch (final SchedulerException schedulerException) {
			log.error(schedulerException.getMessage(), schedulerException);
		}
	}
}