package info.mintymods.jni;

import java.io.File;

import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.mss.webapp.config.MintyConfig;
import info.mintymods.repository.entities.enums.ProviderType;
import info.mintymods.utils.MintyJsonUtils;

public class MsmResponseFactory {

	private static final Logger log = LoggerFactory.getLogger(MsmResponseFactory.class);
	MintyConfig config;

	public MsmResponseFactory(MintyConfig config) {
		this.config = config;
	}

	public MsmMonitorResponse getResponse(MsmMonitorRequest request) {
		final MsmJniWrapper msm = new MsmJniWrapper();
		log.info("@MSM#" + msm);
		final String json = msm.processRequest(request.toString());
		FileUtil.writeAsString(new File("C:\\Users\\Minty\\minty.json"), json);
		final MsmMonitorResponse response = MintyJsonUtils.getMsmMonitorResponse(json);
		return response;
	}

	public MsmMonitorResponse getResponse(ProviderType type) {
		final MsmRequestBuilder builder = new MsmRequestBuilder(config);
		final MsmMonitorRequest request = builder.buildRequest(type);
		return getResponse(request);
	}
}
