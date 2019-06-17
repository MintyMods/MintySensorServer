package info.mintymods.msm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.mss.utils.MssFileUtils;
import info.mintymods.mss.utils.MssJSONUtils;

public class MintySensorMonitor {

	private static final Logger log = LoggerFactory.getLogger(MintySensorMonitor.class);
	private static final int COMMAND_EXEC_TIMEOUT = 60 * 1000;

	public static void init() {
		log.debug("MintySensortiveServer:init()");
	}

	public MsmMonitorResponse getSensorsData(MsmMonitorRequest request) {

		String exe = MssFileUtils.getPathToMintySensorMonitor();
		try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
			CommandLine cmdLine = new CommandLine(exe);
			cmdLine.addArgument(getJsonRequest(request));
			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			ExecuteWatchdog watchdog = new ExecuteWatchdog(COMMAND_EXEC_TIMEOUT);
			Executor executor = new DefaultExecutor();
			executor.setExitValue(1);
			executor.setWatchdog(watchdog);
			PumpStreamHandler streamHandler = new PumpStreamHandler(stream);
			executor.setStreamHandler(streamHandler);
			executor.execute(cmdLine, resultHandler);
			resultHandler.waitFor();
			return MssJSONUtils.getMsmMonitorResponse(stream.toString());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException("Error launching Process Builder for MSM", e);
		}
	}

	static String getJsonRequest(MsmMonitorRequest request) {
		try {
			return MssJSONUtils.getMapper().writeValueAsString(request);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error converting request into JSON", e);
		}
	}

}
