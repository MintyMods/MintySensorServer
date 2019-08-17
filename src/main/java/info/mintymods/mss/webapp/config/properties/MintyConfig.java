package info.mintymods.mss.webapp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "minty")
public class MintyConfig {

	boolean debug;
	private DatabaseConfig database;
	private SchedulerConfig scheduler;
	private ApplicationConfig application;

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(final boolean debug) {
		this.debug = debug;
	}

	public DatabaseConfig getDatabase() {
		return database;
	}

	public void setDatabase(final DatabaseConfig database) {
		this.database = database;
	}

	public SchedulerConfig getScheduler() {
		return scheduler;
	}

	public void setScheduler(final SchedulerConfig scheduler) {
		this.scheduler = scheduler;
	}

	public ApplicationConfig getApplication() {
		return application;
	}

	public void setApplication(ApplicationConfig application) {
		this.application = application;
	}
}
