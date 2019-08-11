package info.mintymods.mss.webapp.database;

import javax.sql.DataSource;

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

	@Autowired
	MintyConfig config;

	@Bean
	public DataSource dataSource() {
		final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		configLoaded(config);
		final EmbeddedDatabase database = builder
				.setDataSourceFactory(new ConfigurableDataSourceFactory(config))
				.setType(EmbeddedDatabaseType.H2)
				.setName(config.getDatabase().getAlias())
				// .addScript("sql/data.sql")
				.build();
		return database;
	}

	private void configLoaded(MintyConfig config2) {
		System.out.println("debug" + config.isDebug());
		System.out.println("alias" + config.getDatabase().getAlias());
		System.out.println("url" + config.getDatabase().getUrl());
		System.out.println("username" + config.getDatabase().getUsername());
		System.out.println("password" + config.getDatabase().getPassword());
		System.out.println("delay" + config.getScheduler().getDelay());
		System.out.println("freq" + config.getScheduler().getFrequency());
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}