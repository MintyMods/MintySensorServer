package info.mintymods.mss.webapp.controller;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

public class ControllerBaseTest {

	@Mock
	protected HttpServletRequest request;

	@Mock
	protected HttpServletResponse response;

	@Mock
	protected HttpSession session;

	protected Map<String, Object> model = new HashMap<String, Object>();
	protected ModelMap modelMap = new ModelMap();

	@Before
	public void beforeTest() {
		when(request.getSession()).thenReturn(session);
		when(request.getSession(true)).thenReturn(session);
	}
}
