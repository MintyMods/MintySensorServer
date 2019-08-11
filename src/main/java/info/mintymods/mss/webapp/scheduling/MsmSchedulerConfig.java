package info.mintymods.mss.webapp.scheduling;

import java.io.IOException;
import java.util.Properties;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Configuration
public class MsmSchedulerConfig {

	private static final Logger log = LoggerFactory.getLogger(MsmSchedulerConfig.class);

	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		final MsmSchedulerJobFactory jobFactory = new MsmSchedulerJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, Trigger msmSchedulerJobTrigger)
			throws IOException {
		final SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setJobFactory(jobFactory);
		factory.setQuartzProperties(quartzProperties());
		factory.setTriggers(msmSchedulerJobTrigger);
		log.info("Starting MsmSchedulerJobs @  " + msmSchedulerJobTrigger.getKey());
		return factory;
	}

	@Bean
	public SimpleTriggerFactoryBean msmSchedulerJobTrigger(@Qualifier("msmSchedulerJobDetail") JobDetail jobDetail,
			@Value("${msm.scheduler.job.frequency}") long frequency) {
		log.info("msmSchedulerJobTrigger msm.scheduler.job.frequency:" + frequency);
		final SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
		factoryBean.setJobDetail(jobDetail);
		factoryBean.setStartDelay(10000L);
		factoryBean.setRepeatInterval(frequency);
		factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		return factoryBean;
	}

	@Bean
	public Properties quartzProperties() throws IOException {
		final PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/config/quartz.properties"));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	@Bean
	public JobDetailFactoryBean msmSchedulerJobDetail() {
		final JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass(MsmSchedulerJob.class);
		factoryBean.setDurability(true);
		return factoryBean;
	}
}