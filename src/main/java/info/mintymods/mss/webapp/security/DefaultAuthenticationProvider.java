package info.mintymods.mss.webapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {

	private static final Logger log = LoggerFactory.getLogger(DefaultAuthenticationProvider.class);

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		UserDetails userDetails = userDetailsService.loadUserByUsername(token.getName());
		// if (userDetails == null) {
		// log.info("Invalid username : {}", token.getName());
		// throw new UsernameNotFoundException(token.getName());
		// }
		// if (!matchPassword(userDetails.getPassword(), token.getCredentials())) {
		// throw new BadCredentialsException("Username or password was not matched.");
		// }
		return new UsernamePasswordAuthenticationToken(authentication.getName(),
				authentication.getCredentials().toString(), userDetails.getAuthorities());
	}

	private boolean matchPassword(String password, Object credentials) {
		return password.equals(credentials);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
