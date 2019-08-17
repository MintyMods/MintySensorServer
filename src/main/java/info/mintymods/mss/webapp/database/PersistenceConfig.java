package info.mintymods.mss.webapp.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import info.mintymods.mss.webapp.config.properties.MintyConfig;

@Configuration
public class PersistenceConfig {

	@Autowired
	MintyConfig config;

	@Bean
	public DataSource dataSource() {
		final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		final EmbeddedDatabase database = builder
				.setDataSourceFactory(new ConfigurableDataSourceFactory(config))
				.setType(EmbeddedDatabaseType.H2)
				.setName(config.getDatabase().getAlias())
				// .addScript("sql/data.sql")
				.build();
		return database;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}