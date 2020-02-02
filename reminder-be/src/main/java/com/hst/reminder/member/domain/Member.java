package com.hst.reminder.member.domain;

import com.hst.reminder.oauth2.domain.OAuth2AuthorizedUser;
import com.hst.reminder.oauth2.domain.OAuth2ProviderType;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.persistence.*;
import java.io.Serializable;
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
public class Member implements UserDetails, OAuth2User, Serializable {
	private static final long serialVersionUID = 5191342461225391114L;

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

	@Column(name = "sso_type")
	@Convert(converter = OAuth2ProviderType.Converter.class)
	private OAuth2ProviderType ssoType;

	@Transient
	private Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

	@Transient
	private Map<String, Object> attributes;

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

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
		if (ssoType == OAuth2ProviderType.LOCAL)  {
			return password.getValue();
		}
		return null;
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

	public static Member createMemberBySSO(OAuth2AuthorizedUser userInfo) {
		Member member = new Member();
		member.password = Password.empty();
		member.email = userInfo.getEmail();
		member.name = userInfo.getResolvedName();
		member.profileImageUrl = userInfo.getImageUrl();
		member.ssoType = userInfo.getoAuth2ProviderType();
		return member;
	}

	public void updateMemberInfo(OAuth2AuthorizedUser oAuth2AuthorizedUser) {
		this.name = oAuth2AuthorizedUser.getResolvedName();
		this.email = oAuth2AuthorizedUser.getEmail();
		this.profileImageUrl = oAuth2AuthorizedUser.getImageUrl();
	}

	public boolean isOriginalSSOProvider(OAuth2ProviderType oAuth2ProviderType) {
		return this.ssoType == oAuth2ProviderType;
	}
}
