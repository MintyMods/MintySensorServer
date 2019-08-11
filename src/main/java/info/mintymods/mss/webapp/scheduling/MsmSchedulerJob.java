package info.mintymods.mss.webapp.scheduling;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import info.mintymods.jni.MsmResponseFactory;
import info.mintymods.mss.webapp.config.MintyConfig;
import info.mintymods.mss.webapp.services.MsmResponseService;
import info.mintymods.repository.entities.enums.ProviderType;

public class MsmSchedulerJob implements Job {

	@Autowired
	private MsmResponseService service;
	@Autowired
	MintyConfig config;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		final MsmResponseFactory factory = new MsmResponseFactory(config);
		service.processResponse(factory.getResponse(getProviderType()));
	}

	private ProviderType getProviderType() {
		return ProviderType.HWINFO; // @todo Move this somewhere central
	}
}