package info.mintymods.mss.webapp.controller.error;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MintyErrorController extends BasicErrorController {

	public MintyErrorController() {
		super(new MintyErrorAttributes(), new MintyErrorProperties());
	}

	@Override
	public ModelAndView errorHtml(final HttpServletRequest request, final HttpServletResponse response) {
		final HttpStatus status = getStatus(request);
		final String value = String.valueOf(status.value());
		final String reasonPhrase = status.getReasonPhrase();
		try {
			final Map<String, Object> body = getErrorAttributes(request,
					isIncludeStackTrace(request, MediaType.ALL));
			body.put("status", getStatus(request));
			body.put("body", String.format("Status %s VAlue %s Phrase %s", reasonPhrase, value, reasonPhrase));
			response.getWriter().print(body);
		} catch (final IOException e) {
			return super.errorHtml(request, response);
		}
		return null;
	}

	@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String errorTextPlan(final HttpServletRequest request) {
		final Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.ALL));
		body.put("status", getStatus(request));
		return body.toString();
	}
}
