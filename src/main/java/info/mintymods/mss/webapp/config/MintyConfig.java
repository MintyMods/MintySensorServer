package info.mintymods.mss.webapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "minty")
public class MintyConfig {
	// Set hibernate.listeners.envers.autoRegister to false, unless it's
	// deliberately set to true (reverse the regular behavior), so folks
	// have to enable it deliberately.
	// UPDATE THE properties file ato add a new property
	// Properties configurationProps = getHibernateSettings();
	// if (configurationProps.getProperty("hibernate.listeners.envers.autoRegister") == null) {
	// configurationProps.setProperty("hibernate.listeners.envers.autoRegister", "false");
	// }
	// configuration.setProperties(getHibernateSettings());

	boolean debug;
	private Database database;
	private Scheduler scheduler;

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
}
