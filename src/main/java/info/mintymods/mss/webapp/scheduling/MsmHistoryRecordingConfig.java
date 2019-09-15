package info.mintymods.mss.webapp.scheduling;

import java.io.IOException;
import java.util.Properties;

import org.quartz.JobDetail;
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
public class MsmHistoryRecordingConfig {

	private static final Logger log = LoggerFactory.getLogger(MsmHistoryRecordingConfig.class);
	@Autowired
	MintyConfig config;

	@Bean
	public JobFactory historyRecordingjobFactory(final ApplicationContext applicationContext) {
		final MsmSchedulerJobFactory jobFactory = new MsmSchedulerJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	@Bean
	public SchedulerFactoryBean historyRecordingFactoryBean(@Qualifier("historyRecordingjobFactory") final JobFactory jobFactory,
			@Qualifier("historyRecordingJobTrigger") final Trigger jobTrigger)
			throws IOException {
		final SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setJobFactory(jobFactory);
		factory.setQuartzProperties(historyRecordingProperties());
		factory.setTriggers(jobTrigger);
		return factory;
	}

	@Bean
	public SimpleTriggerFactoryBean historyRecordingJobTrigger(@Qualifier("historyRecoringJobDetail") final JobDetail jobDetail,
			@Value("${minty.scheduler.frequency}") final long frequency) {
		final SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
		factoryBean.setJobDetail(jobDetail);
		log.debug("minty.scheduler.delay@" + config.getScheduler().getDelay());
		factoryBean.setStartDelay(config.getScheduler().getDelay());
		factoryBean.setRepeatInterval(config.getScheduler().getFrequency());
		factoryBean.setRepeatCount(1);
		// factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		return factoryBean;
	}

	@Bean
	public Properties historyRecordingProperties() throws IOException {
		final PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource(config.getScheduler().getPropertiesFile()));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	@Bean
	public JobDetailFactoryBean historyRecoringJobDetail() {
		final JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass(MsmHistoryRecordingJob.class);
		factoryBean.setDurability(true);
		return factoryBean;
	}
}