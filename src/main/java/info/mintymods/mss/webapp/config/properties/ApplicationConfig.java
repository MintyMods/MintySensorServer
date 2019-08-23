package info.mintymods.mss.webapp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "minty.application")
public class ApplicationConfig {

	private String name;
	private String description;
	private String url;
	private String email;
	private String author;
	private String version;
	private String password;
	private String alias;
	private String domainName;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(final String alias) {
		this.alias = alias;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(final String domainName) {
		this.domainName = domainName;
	}
}
