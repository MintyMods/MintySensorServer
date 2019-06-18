package info.mintymods.repository.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import info.mintymods.repository.domain.Account;

public class SecureAccount implements UserDetails {

	private static final long serialVersionUID = 1263911633172584310L;
	private Account account;
	private List<GrantedAuthority> authorities;

	public SecureAccount(Account account) {
		this.account = account;
		setAuthorities(account);
	}

	private void setAuthorities(Account account) {
		authorities = new ArrayList<>();
		account.getRoles()
				.forEach(accountRole -> authorities.add(new SimpleGrantedAuthority(accountRole.getRoleName())));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !account.isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return account.isActivated();
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(final Account account) {
		this.account = account;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "SecureAccount(account=" + this.getAccount() + ", authorities=" + this.getAuthorities() + ")";
	}
}
