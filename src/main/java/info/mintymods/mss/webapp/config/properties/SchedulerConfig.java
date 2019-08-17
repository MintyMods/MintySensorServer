package info.mintymods.mss.webapp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "minty.scheduler")
public class SchedulerConfig {

	private Long delay;
	private Long frequency;

	public Long getDelay() {
		return delay;
	}

	public void setDelay(final Long delay) {
		this.delay = delay;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(final Long frequency) {
		this.frequency = frequency;
	}

	public String getPropertiesFile() {
		return "/config/scheduler.properties";
	}
}
