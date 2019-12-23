package com.hst.reminder.member.domain;

import com.hst.reminder.member.application.command.SignupRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "MEMBER")
@Getter
@RequiredArgsConstructor
public class Member implements UserDetails {
	@EmbeddedId
	private MemberId id;

	@Embedded
	private Password password;

	private String email;

	private String name;

	@Column(name = "SSO_TYPE")
	private SSOType ssoType;

	// TODO 권한 관련 부분은 우선 ROLE_USER 만 고려해서 구현 (추후 admin 추가 시 구현할 것)
	@Transient
	private Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return this.id.getId().toString();
	}

	@Override
	public String getPassword() {
		return password.getValue();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public static Member createMemberByReminder(SignupRequest request) {
		Member member = new Member();
		member.email = request.getEmail();
		member.name = request.getName();
		// member.password = request.getPassword();
		return member;
	}

}
