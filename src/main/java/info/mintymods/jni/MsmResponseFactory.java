package info.mintymods.jni;

import java.io.File;

import org.aspectj.util.FileUtil;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.webapp.config.MintyConfig;
import info.mintymods.mss.webapp.exception.MsmServiceProviderUnavailableException;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.utils.MintyJsonUtils;

public class MsmResponseFactory {

	MintyConfig config;

	public MsmResponseFactory(MintyConfig config) {
		this.config = config;
	}

	public MsmMonitorResponse getResponse(MsmMonitorRequest request) throws MsmServiceProviderUnavailableException {
		final MsmJniWrapper msm = new MsmJniWrapper();
		final String json = msm.processRequest(request.toString());
		FileUtil.writeAsString(new File("C:\\Users\\Minty\\minty.json"), json);
		final MsmMonitorResponse response = MintyJsonUtils.getMsmMonitorResponse(json);
		return response;
	}

	public MsmMonitorResponse getResponse(ProviderType type) throws MsmServiceProviderUnavailableException {
		final MsmRequestBuilder builder = new MsmRequestBuilder(config);
		final MsmMonitorRequest request = builder.buildRequest(type);
		return getResponse(request);
	}
}
