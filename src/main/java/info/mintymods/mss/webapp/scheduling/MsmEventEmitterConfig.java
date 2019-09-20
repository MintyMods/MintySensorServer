package info.mintymods.mss.webapp.scheduling;

import java.io.IOException;
import java.util.Properties;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import info.mintymods.mss.webapp.config.properties.MintyConfig;

@Configuration
public class MsmEventEmitterConfig {

	private static final Logger log = LoggerFactory.getLogger(MsmEventEmitterConfig.class);
	@Autowired
	MintyConfig config;
	@Autowired
	@Qualifier("eventEmitterJobTrigger")
	SimpleTriggerFactoryBean factoryBean;

	@Bean
	public JobFactory eventEmitterJobFactory(final ApplicationContext applicationContext) {
		final MsmSchedulerJobFactory jobFactory = new MsmSchedulerJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	@Bean
	public SchedulerFactoryBean eventEmitterFactoryBean(@Qualifier("eventEmitterJobFactory") final JobFactory jobFactory,
			@Qualifier("eventEmitterJobTrigger") final Trigger jobTrigger)
			throws IOException {
		final SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setJobFactory(jobFactory);
		factory.setQuartzProperties(eventEmitterProperties());
		factory.setTriggers(jobTrigger);
		return factory;
	}

	@Bean
	public SimpleTriggerFactoryBean eventEmitterJobTrigger(@Qualifier("eventEmitterJobDetail") final JobDetail jobDetail,
			@Value("${minty.scheduler.polling}") final long frequency) {
		SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
		trigger.setJobDetail(jobDetail);
		log.debug("minty.scheduler.polling@" + config.getScheduler().getPolling());
		trigger.setStartDelay(config.getScheduler().getDelay());
		trigger.setRepeatInterval(config.getScheduler().getPolling());
		trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		return trigger;
	}

	@Bean
	public Properties eventEmitterProperties() throws IOException {
		final PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource(config.getScheduler().getPropertiesFile()));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	@Bean
	public JobDetailFactoryBean eventEmitterJobDetail() {
		final JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass(MsmEventEmitterJob.class);
		factoryBean.setDurability(true);
		return factoryBean;
	}
}