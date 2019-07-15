package info.mintymods.jni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.utils.MintyJsonUtils;

public class ResponseFactory {
	
	private static final Logger log = LoggerFactory.getLogger(ResponseFactory.class);
	
	public MsmMonitorResponse getResponse(MsmMonitorRequest request) {
		final MsmJniWrapper msm = new MsmJniWrapper();
		log.info("@MSM#" + msm);
		String json = msm.processRequest(request.toString());
		MsmMonitorResponse response = MintyJsonUtils.getMsmMonitorResponse(json);
		return response;
	}

	
	
}
