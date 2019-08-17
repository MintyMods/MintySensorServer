package info.mintymods.jni;

import info.mintymods.MintySensorServer;
import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.repository.entities.enums.ProviderType;

public class MsmRequestBuilder {

	public MsmMonitorRequest buildRequest(final ProviderType type) {
		final MsmMonitorRequest request = new MsmMonitorRequest();
		switch (type) {
			case HWINFO :
				request.setSource("MSM[JSON]HWiNFO");
				break;
			case GPUZ :
				request.setSource("MSM[JSON]GPUZ");
				break;
			case OHM :
				request.setSource("MSM[JSON]OHM");
				break;
			default :
				request.setSource("MSM[JSON]EXAMPLE");
		}
		request.setDebug(MintySensorServer.config.isDebug());
		return request;
	}
}
