package info.mintymods.mss.webapp.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@EnableJpaRepositories("info.mintymods.repository.dao")
@ComponentScan(basePackages = {"info.mintymods.mss.webapp"})
@EntityScan("info.mintymods.repository.entities")
@Configuration
public class PersistenceConfig {

	@Bean
	public DataSource dataSource() {
		final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		final EmbeddedDatabase db = builder
				.setType(EmbeddedDatabaseType.H2)
				// .addScript("sql/data.sql")
				.build();
		return db;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}