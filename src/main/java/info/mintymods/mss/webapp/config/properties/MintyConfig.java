package info.mintymods.mss.webapp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "minty")
public class MintyConfig {

	public static final String MSS_PROPERTIES = "application.properties";
	private static MintyConfig instance = null;
	boolean debug;
	private DatabaseConfig database;
	private SchedulerConfig scheduler;
	private ApplicationConfig application;
	private ErrorConfig error;

	public static MintyConfig getInstance() {
		if (instance == null) {
			instance = new MintyConfig();
		}
		return instance;
	}

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

	public void setApplication(final ApplicationConfig application) {
		this.application = application;
	}

	public ErrorConfig getError() {
		return error;
	}

	public void setError(final ErrorConfig error) {
		this.error = error;
	}

	public char[] getPassword() {
		return getApplication().getPassword().toCharArray();
	}

	public String getAlias() {
		return getApplication().getAlias();
	}

	public String getDomainName() {
		return getApplication().getDomainName();
	}
}
