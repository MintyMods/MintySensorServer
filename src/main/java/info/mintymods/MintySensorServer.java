package info.mintymods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import info.mintymods.mss.webapp.config.properties.MintyConfig;
import info.mintymods.mss.webapp.ssl.SslApplicationListener;
import info.mintymods.repository.entities.enums.ProviderType;

@SpringBootApplication
@EnableJpaRepositories("info.mintymods.repository.dao")
@EntityScan("info.mintymods.repository.entities")
@ComponentScan(basePackages = {"info.mintymods"})
@ServletComponentScan
@EnableConfigurationProperties(MintyConfig.class)
public class MintySensorServer extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(MintySensorServer.class);
	public static MintyConfig config;

	public static void main(final String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MintySensorServer.class);
		builder.listeners(new SslApplicationListener());
		ConfigurableApplicationContext context = builder.run(args);
		config = context.getBean(MintyConfig.class);
		log.info("@JavaVersion#" + context.getEnvironment().getProperty("java.runtime.version"));
		log.info("Database URL:" + config.getDatabase().getUrl());
		log.info("Database Alias:" + config.getDatabase().getAlias());
	}

	public static MintyConfig getConfig() {
		return config;
	}

	public static ProviderType getProviderType() {
		return ProviderType.HWINFO;
	}
}
