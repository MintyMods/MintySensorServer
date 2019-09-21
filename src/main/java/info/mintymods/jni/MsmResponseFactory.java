package info.mintymods.jni;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.webapp.config.properties.MintyConfig;
import info.mintymods.mss.webapp.exception.MsmServiceProviderUnavailableException;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.utils.MintyFileUtils;
import info.mintymods.utils.MintyJsonUtils;
import info.mintymods.utils.MintyPathUtils;

@Component
public class MsmResponseFactory {

	@Autowired
	MsmJniWrapper msm;
	@Autowired
	MintyConfig config;
	private boolean demo = true;
	private static int count;
	private static final Logger log = LoggerFactory.getLogger(MsmResponseFactory.class);

	public MsmMonitorResponse getResponse(final MsmMonitorRequest request) throws MsmServiceProviderUnavailableException {
		final String json = msm.processRequest(request.toString());
		if (config.isDebug() || demo) {
			if (count > 500) {
				demo = false;
			}
			MintyFileUtils.writeAsString(getResponseLogFile(), json);
		}
		final MsmMonitorResponse response = MintyJsonUtils.getMsmMonitorResponse(json);
		return response;
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
