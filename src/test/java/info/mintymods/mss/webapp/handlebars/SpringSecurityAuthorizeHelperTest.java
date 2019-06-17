package info.mintymods.mss.webapp.handlebars;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.github.jknack.handlebars.Options;

import info.mintymods.mss.webapp.handlebars.SpringSecurityAuthorizeHelper;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringBootWebApplication.class)
//@TestPropertySource(properties = "spring.config.location=classpath:application-test.properties")
public class SpringSecurityAuthorizeHelperTest {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(SpringSecurityAuthorizeHelperTest.class);
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	@Autowired
	private SpringSecurityAuthorizeHelper helper;
	@Mock
	private Object context;
	@Mock
	private Options options;
	@Mock
	private Options.Buffer buffer;
	@Mock
	private Authentication authentication;
	@Mock
	private SecurityContext securityContext;

	@Before
	public void before() {
		when(securityContext.getAuthentication()).thenReturn(authentication);
	}

	// @Test
	public void testApplyWithoutAuthentication() throws Exception {
		String optionInverse = "inverse";
		when(context.toString()).thenReturn("hasRole(\'ROLE_ADMIN\')");
		when(options.buffer()).thenReturn(buffer);
		when(options.inverse()).thenReturn(optionInverse);
		Object object = helper.apply(context, options);
//		assertThat("Unexpected value.", object, is(buffer));
//		verify(buffer).append(optionInverse);
	}

	// @Test
	public void testApplyWithAuthentication() throws Exception {
		String optionFn = "fn";
		SecurityContextHolder.setContext(securityContext);
		when(context.toString()).thenReturn("hasRole(\'ROLE_ADMIN\')");
		when(options.buffer()).thenReturn(buffer);
		when(options.inverse()).thenReturn(optionFn);
		Object object = helper.apply(context, options);
//		assertThat("Unexpected value.", object, is(buffer));
//		verify(buffer).append(optionFn);
	}
}
