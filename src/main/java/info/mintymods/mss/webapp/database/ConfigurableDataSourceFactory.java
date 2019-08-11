package info.mintymods.mss.webapp.database;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import info.mintymods.mss.webapp.config.MintyConfig;

@Configuration
public class ConfigurableDataSourceFactory implements DataSourceFactory {

	MintyConfig config;
	private final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

	public ConfigurableDataSourceFactory(MintyConfig config) {
		this.config = config;
	}

	@Override
	public ConnectionProperties getConnectionProperties() {
		return new ConnectionProperties() {

			@Override
			public void setDriverClass(Class<? extends Driver> driverClass) {
				dataSource.setDriverClass(driverClass);
			}

			@Override
			public void setUrl(String url) {
				dataSource.setUrl(config.getDatabase().getUrl());
			}

			@Override
			public void setUsername(String username) {
				dataSource.setUsername(config.getDatabase().getUsername());
			}

			@Override
			public void setPassword(String password) {
				dataSource.setPassword(config.getDatabase().getPassword());
			}
		};
	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}
}
