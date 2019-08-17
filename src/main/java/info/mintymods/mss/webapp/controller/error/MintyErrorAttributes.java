package info.mintymods.mss.webapp.controller.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Component
public class MintyErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(final WebRequest webRequest, final boolean includeStackTrace) {
		final Map<String, Object> body = super.getErrorAttributes(webRequest, includeStackTrace);
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		body.put("locale", webRequest.getLocale().toString());
		body.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
		body.put("exceptionType", request.getAttribute("javax.servlet.error.exception_type"));
		body.put("message", request.getAttribute("javax.servlet.error.message"));
		body.put("requestUri", request.getAttribute("javax.servlet.error.request_uri"));
		body.put("exception", request.getAttribute("javax.servlet.error.exception"));
		body.put("servletName", request.getAttribute("javax.servlet.error.servlet_name"));
		body.put("path", "/mintyerror");
		body.remove("error");
		return body;
	}
}
