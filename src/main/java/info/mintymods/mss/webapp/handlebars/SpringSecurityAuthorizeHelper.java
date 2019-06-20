// package info.mintymods.mss.webapp.handlebars;
//
// import java.io.IOException;
// import java.util.Map;
//
// import javax.annotation.PostConstruct;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
//
// import org.jetbrains.annotations.NotNull;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.ApplicationContext;
// import org.springframework.core.GenericTypeResolver;
// import org.springframework.expression.EvaluationContext;
// import org.springframework.expression.Expression;
// import org.springframework.expression.ParseException;
// import org.springframework.security.access.expression.ExpressionUtils;
// import org.springframework.security.access.expression.SecurityExpressionHandler;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.FilterInvocation;
// import org.springframework.web.context.request.RequestContextHolder;
// import org.springframework.web.context.request.ServletRequestAttributes;
//
// import com.github.jknack.handlebars.Helper;
// import com.github.jknack.handlebars.Options;
// import com.github.jknack.handlebars.Options.Buffer;
//
//// @Component
// public class SpringSecurityAuthorizeHelper implements Helper<Object> {
//
// private static final Logger log = LoggerFactory.getLogger(SpringSecurityAuthorizeHelper.class);
// public static final String NAME = "sec:authorize";
//
// @Autowired
// private ApplicationContext context;
//
// @Autowired
// private SecurityExpressionHandler<FilterInvocation> securityExpressionHandler;
//
// @PostConstruct
// public void init() throws IOException {
// securityExpressionHandler = getExpressionHandler();
// }
//
// @Override
// public Object apply(Object context, Options options) throws IOException {
// log.warn("context : {}", context);
// Buffer buffer = options.buffer();
// if (evaluateAuthority(context.toString())) {
// buffer.append(options.fn());
// } else {
// buffer.append(options.inverse());
// }
// return buffer;
// }
//
// private boolean evaluateAuthority(String access) throws IOException {
// if (SecurityContextHolder.getContext().getAuthentication() == null) {
// return false;
// }
// return ExpressionUtils.evaluateAsBoolean(getAccessExpression(access), createExpressionEvaluationContext());
// }
//
// private EvaluationContext createExpressionEvaluationContext() {
// ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
// FilterInvocation invocation = new FilterInvocation(attributes.getRequest(), attributes.getResponse(),
// new FilterChain() {
//
// @Override
// public void doFilter(ServletRequest request, ServletResponse response)
// throws IOException, ServletException {
// throw new UnsupportedOperationException();
// }
// });
// return securityExpressionHandler.createEvaluationContext(SecurityContextHolder.getContext().getAuthentication(),
// invocation);
// }
//
// @NotNull
// private Expression getAccessExpression(String access) throws IOException {
// Expression accessExpression = null;
// try {
// accessExpression = securityExpressionHandler.getExpressionParser().parseExpression(access);
// } catch (ParseException e) {
// throw new IOException(e);
// }
// return accessExpression;
// }
//
// private SecurityExpressionHandler<FilterInvocation> getExpressionHandler() throws IOException {
// Map<String, SecurityExpressionHandler> handlerMap = context.getBeansOfType(SecurityExpressionHandler.class);
// for (SecurityExpressionHandler handler : handlerMap.values()) {
// if (FilterInvocation.class.equals(
// GenericTypeResolver.resolveTypeArgument(handler.getClass(), SecurityExpressionHandler.class))) {
// return handler;
// }
// }
// throw new IOException("No visible SecurityExpressionHandler instance could be found in the application");
// }
//
// }
