package info.mintymods.msm.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MsmNativeException extends Exception {

	private static final long serialVersionUID = -6046784807917805736L;
	private String className;
	private String message;
	private Object data;
	private MsmNativeException innerException;
	private String helpURL;
	private String stackTraceString;
	private String remoteStackTraceString;
	private int remoteStackIndex;
	private String exceptionMethod;
	private int hResult;
	private String source;
	private Object watsonBuckets;
	private String fileNotFound_FileName;
	private String fileNotFound_FusionLog;

	public String getClassName() {
		return className;
	}

	@JsonProperty("ClassName")
	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@JsonProperty("Message")
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	@JsonProperty("Data")
	public void setData(Object data) {
		this.data = data;
	}

	public MsmNativeException getInnerException() {
		return innerException;
	}

	@JsonProperty("InnerException")
	public void setInnerException(MsmNativeException innerException) {
		this.innerException = innerException;
	}

	public String getHelpURL() {
		return helpURL;
	}

	@JsonProperty("HelpURL")
	public void setHelpURL(String helpURL) {
		this.helpURL = helpURL;
	}

	public String getStackTraceString() {
		return stackTraceString;
	}

	@JsonProperty("StackTraceString")
	public void setStackTraceString(String stackTraceString) {
		this.stackTraceString = stackTraceString;
	}

	public int getRemoteStackIndex() {
		return remoteStackIndex;
	}

	@JsonProperty("RemoteStackIndex")
	public void setRemoteStackIndex(int remoteStackIndex) {
		this.remoteStackIndex = remoteStackIndex;
	}

	public String getExceptionMethod() {
		return exceptionMethod;
	}

	@JsonProperty("ExceptionMethod")
	public void setExceptionMethod(String exceptionMethod) {
		this.exceptionMethod = exceptionMethod;
	}

	public int getHResult() {
		return hResult;
	}

	@JsonProperty("HResult")
	public void setHResult(int hResult) {
		this.hResult = hResult;
	}

	public String getSource() {
		return source;
	}

	@JsonProperty("Source")
	public void setSource(String source) {
		this.source = source;
	}

	public Object getWatsonBuckets() {
		return watsonBuckets;
	}

	@JsonProperty("WatsonBuckets")
	public void setWatsonBuckets(Object watsonBuckets) {
		this.watsonBuckets = watsonBuckets;
	}

	public String getFileNotFound_FileName() {
		return fileNotFound_FileName;
	}

	@JsonProperty("FileNotFound_FileName")
	public void setFileNotFound_FileName(String fileNotFound_FileName) {
		this.fileNotFound_FileName = fileNotFound_FileName;
	}

	public String getFileNotFound_FusionLog() {
		return fileNotFound_FusionLog;
	}

	@JsonProperty("FileNotFound_FusionLog")
	public void setFileNotFound_FusionLog(String fileNotFound_FusionLog) {
		this.fileNotFound_FusionLog = fileNotFound_FusionLog;
	}

	public String getRemoteStackTraceString() {
		return remoteStackTraceString;
	}

	@JsonProperty("RemoteStackTraceString")
	public void setRemoteStackTraceString(String remoteStackTraceString) {
		this.remoteStackTraceString = remoteStackTraceString;
	}
}
