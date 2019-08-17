package info.mintymods.mss.webapp.database;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import info.mintymods.mss.webapp.config.MintyConfig;

@Configuration
public class PersistenceConfig {

	private static final Logger log = LoggerFactory.getLogger(PersistenceConfig.class);
	@Autowired
	MintyConfig config;

	@Bean
	public DataSource dataSource() {
		final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		logConfig();
		final EmbeddedDatabase database = builder
				.setDataSourceFactory(new ConfigurableDataSourceFactory(config))
				.setType(EmbeddedDatabaseType.H2)
				.setName(config.getDatabase().getAlias())
				// .addScript("sql/data.sql")
				.build();
		return database;
	}

	private void logConfig() {
		log.debug("debug" + config.isDebug());
		log.debug("alias" + config.getDatabase().getAlias());
		log.debug("url" + config.getDatabase().getUrl());
		log.debug("username" + config.getDatabase().getUsername());
		log.debug("password" + config.getDatabase().getPassword());
		log.debug("delay" + config.getScheduler().getDelay());
		log.debug("freq" + config.getScheduler().getFrequency());
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}