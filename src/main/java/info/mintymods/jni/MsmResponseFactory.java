package info.mintymods.jni;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.webapp.exception.MsmServiceProviderUnavailableException;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.utils.MintyJsonUtils;

public class MsmResponseFactory {

	public MsmMonitorResponse getResponse(final MsmMonitorRequest request) throws MsmServiceProviderUnavailableException {
		final MsmJniWrapper msm = new MsmJniWrapper();
		final String json = msm.processRequest(request.toString());
		return MintyJsonUtils.getMsmMonitorResponse(json);
	}

	public MsmMonitorResponse getResponse(final ProviderType type) throws MsmServiceProviderUnavailableException {
		final MsmRequestBuilder builder = new MsmRequestBuilder();
		final MsmMonitorRequest request = builder.buildRequest(type);
		return getResponse(request);
	}
}
