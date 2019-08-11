package info.mintymods.mss.webapp.scheduling;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import info.mintymods.jni.MsmJniWrapper;
import info.mintymods.msm.MsmMonitorRequest;
import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.utils.MintyJsonUtils;

public class MsmSchedulerJob implements Job {

	private static final Logger log = LoggerFactory.getLogger(MsmSchedulerJob.class);
	private static final MsmJniWrapper msm;
	private static final MsmMonitorRequest request;
	static {
		msm = new MsmJniWrapper();
		request = new MsmMonitorRequest();
		request.setSource(MsmJniWrapper.SOURCE);
		request.setDebug(MsmJniWrapper.DEBUG);
		log.info("@MSM#" + msm);
		log.info("@request#" + request.toString());
	}
	@Autowired
	private MsmSchedulerService service;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		log.info("MsmSchedulerJob Polling...");
		final String json = msm.processRequest(request.toString());
		final MsmMonitorResponse response = MintyJsonUtils.getMsmMonitorResponse(json);
		service.processResponse(response);
	}
}