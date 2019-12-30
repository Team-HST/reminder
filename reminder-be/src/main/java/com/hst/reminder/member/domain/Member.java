package com.hst.reminder.member.domain;

import com.hst.reminder.member.application.command.SignupRequest;
import com.hst.reminder.oauth2.OAuth2Provider;
import com.hst.reminder.oauth2.user.OAuth2UserInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "MEMBER")
@Getter
@RequiredArgsConstructor
public class Member implements OAuth2User, UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	@AttributeOverrides(
		@AttributeOverride(name = "value", column = @Column(name ="password"))
	)
	private Password password;

	@Column(unique = true)
	private String email;

	@Column
	private String name;

	@Column(name = "profile_image_url")
	private String profileImageUrl;

	@Column(name = "sso_provider")
	private OAuth2Provider ssoProvider;

	@Transient
	private Map<String, Object> attributes;

	@Transient
	private Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return this.id.toString();
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

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public static Member createMemberByReminder(SignupRequest request, Password password) {
		Member member = new Member();
		member.email = request.getEmail();
		member.name = request.getName();
		member.password = password;
		return member;
	}

	public static Member createMemberBySosial(OAuth2UserInfo userInfo, OAuth2Provider oAuth2Provider) {
		Member member = new Member();
		member.email = userInfo.getEmail();
		member.name = userInfo.getName();
		member.profileImageUrl = userInfo.getImageUrl();
		member.ssoProvider = oAuth2Provider;
		return member;
	}

	public void updateMemberInfo(OAuth2UserInfo oAuth2UserInfo) {
		this.name = oAuth2UserInfo.getName();
		this.email = oAuth2UserInfo.getEmail();
		this.profileImageUrl = oAuth2UserInfo.getImageUrl();
	}
}
