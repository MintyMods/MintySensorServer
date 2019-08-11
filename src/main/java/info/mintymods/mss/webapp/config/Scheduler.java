package info.mintymods.mss.webapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "minty.scheduler")
public class Scheduler {

	private Long delay;
	private Long frequency;

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}

	public String getPropertiesFile() {
		return "/config/scheduler.properties";
	}
}
