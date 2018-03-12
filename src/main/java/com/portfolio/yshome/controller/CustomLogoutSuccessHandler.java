package com.portfolio.yshome.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse res, Authentication att)
			throws IOException, ServletException {
		if (att != null && att.getDetails() != null) {
			try {
				req.getSession().invalidate();
				System.out.println("로그아웃 성공");
			} catch (Exception e) {
				e.printStackTrace();
			}
			res.setStatus(res.SC_OK);
			// 리다이렉트 로그인
			res.sendRedirect("/yshome/listAll");
		}
	}

}
