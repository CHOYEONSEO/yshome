package com.portfolio.yshome.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.portfolio.yshome.domain.MemberDTO;
import com.portfolio.yshome.service.MemberService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Inject
	private MemberService service;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String user_id = (String) authentication.getPrincipal();
		String user_pw = (String) authentication.getCredentials();
		logger.info("아이디 : {}" + user_id);
		try {
			MemberDTO mDto = new MemberDTO();
			mDto.setId(user_id);
			mDto.setPw(user_pw);
			mDto = service.login(mDto);
			if (mDto == null) {
				 return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("로그인 인증 중입니다. {}" + "아이디 : " + user_id + "비밀번호 : " + user_pw);

		// check whether user's credentials are valid.
		// if false, throw new
		// BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials",
		// "Bad credentials"));

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));

		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
		result.setDetails(new CustomUserDetails(user_id, user_pw));
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
