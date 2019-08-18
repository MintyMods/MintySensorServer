package info.mintymods.mss.webapp.config.properties;

import org.springframework.boot.autoconfigure.web.ErrorProperties.IncludeStacktrace;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "minty.error")
public class ErrorConfig extends MintyConfig {

	private boolean includeStackTraces;
	private boolean includeException;

	public boolean isIncludeStackTraces() {
		return includeStackTraces;
	}

	public void setIncludeStackTraces(final boolean includeStackTraces) {
		this.includeStackTraces = includeStackTraces;
	}

	public boolean isIncludeException() {
		return includeException;
	}

	public void setIncludeException(final boolean includeException) {
		this.includeException = includeException;
	}

	public IncludeStacktrace getIncludeStackTraces() {
		if (includeStackTraces) {
			return isDebug() ? IncludeStacktrace.ALWAYS : IncludeStacktrace.ON_TRACE_PARAM;
		}
		return IncludeStacktrace.NEVER;
	}
}
