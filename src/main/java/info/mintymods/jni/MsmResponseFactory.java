package info.mintymods.jni;

import java.io.File;

import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.webapp.config.properties.MintyConfig;
import info.mintymods.mss.webapp.exception.MsmServiceProviderUnavailableException;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.utils.MintyFileUtils;
import info.mintymods.utils.MintyJsonUtils;
import info.mintymods.utils.MintyPathUtils;

public class MsmResponseFactory {

	MintyConfig config;
	private final boolean demo = true;
	private static int count;

	public MsmResponseFactory(final MintyConfig config) {
		this.config = config;
	}

	public MsmMonitorResponse getResponse(final MsmMonitorRequest request) throws MsmServiceProviderUnavailableException {
		final MsmJniWrapper msm = new MsmJniWrapper();
		final String json = msm.processRequest(request.toString());
		if (config.isDebug()) {
			MintyFileUtils.writeAsString(getResponseLogFile(), json);
		}
		final MsmMonitorResponse response = MintyJsonUtils.getMsmMonitorResponse(json);
		matchServicePollingInterval(response);
		return response;
	}

	private void matchServicePollingInterval(final MsmMonitorResponse response) {
		final SimpleTriggerFactoryBean factory = config.getQuartzTriggerFactory();
		final Long period = response.getPolling_period();
		factory.setRepeatInterval(period);
	}

	private File getResponseLogFile() {
		final String filename = demo ? "msm_sample_data_" + String.format("%05d", count++) + ".json" : "msm_last_response.json";
		return new File(MintyPathUtils.getLogFolderPath() + File.separator + filename);
	}

	public MsmMonitorResponse getResponse(final ProviderType type) throws MsmServiceProviderUnavailableException {
		final MsmRequestBuilder builder = new MsmRequestBuilder(config);
		final MsmMonitorRequest request = builder.buildRequest(type);
		return getResponse(request);
	}
}
