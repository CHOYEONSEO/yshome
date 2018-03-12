package com.portfolio.yshome.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.portfolio.yshome.domain.MemberDTO;
import com.portfolio.yshome.service.MemberService;

@Controller
@RequestMapping("/yshome/*")
@SessionAttributes("id")
public class Membercontroller {

	private static final Logger logger = LoggerFactory.getLogger(Membercontroller.class);

	@Inject
	private MemberService service;

	@RequestMapping(value = "/login_form", method = RequestMethod.GET)
	public String loginForm() throws Exception {
		logger.info("로그인 화면 이동");
		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) throws Exception {
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		ip = req.getRemoteAddr();
		logger.info("클라이언트 아이피 ===========> {}" + ip);
		/*if (ip.equals("0:0:0:0:0:0:0:1")) {
			model.addAttribute("fail", "현재 아이디가 접속중입니다. 재 로그인 해주세요.");
			return "redirect:/member/login";
		}*/
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getDetails();
		session.setAttribute("id", userDetails.getUsername());
		logger.info("세션 확인중 =====>" + session.getAttributeNames() + "/ " + userDetails.getUsername());
		return "redirect:/yshome/listAll";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(/* SessionStatus sessionStatus, Model model */) throws Exception {
		// sessionStatus.setComplete();
		return "redirect:/yshome/listAll";
	}

	@RequestMapping(value = "/join_form", method = RequestMethod.GET)
	public String joinForm() throws Exception {
		return "member/join_form";
	}

	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public @ResponseBody int idCheck(MemberDTO mDto) throws Exception {
		System.out.println("접속햇냐");
		System.out.println(mDto.toString());
		int result = service.idCheck(mDto);
		System.out.println(result);
		return result;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDTO mDto, Model model) throws Exception {
		System.out.println(mDto.toString());
		int result = service.join(mDto);
		System.out.println(result);
		if (result == 1) {
			return "redirect:/yshome/login_form";
		} else {
			return "redirect:/yshome/join_form";
		}
	}

	@RequestMapping(value = "/mypage_form", method = RequestMethod.GET)
	public String mypage_form(String id, Model model) throws Exception {
		logger.info("세션값=============>" + id);

		MemberDTO mDto = service.mypage(id);
		mDto.setPw("");
		model.addAttribute("mlist", mDto);
		return "member/mypage";
	}

	@RequestMapping(value = "/mypageEdit_form", method = RequestMethod.POST)
	public String memberEdit(MemberDTO mDto, Model model) throws Exception {
		logger.info("가져오는 값 {}" + mDto.toString());
		mDto = service.login(mDto);
		if (mDto == null) {
			model.addAttribute("msg", "비밀번호가 잘못되었습니다.");
			return "member/mypage";
		} else {
			logger.info("서비스 값" + mDto.toString());
			model.addAttribute("mlist", mDto);
			model.addAttribute("succ", "1");
			return "member/mypage";
		}
	}

	@RequestMapping(value = "/mypageEdit", method = RequestMethod.POST)
	public String mypageEdit(MemberDTO mDto, Model model) throws Exception {
		service.mypageEdit(mDto);
		return "redirect:/yshome/mypage_form";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(MemberDTO mDto, SessionStatus sessionStatus, Model model) throws Exception {
		service.delete(mDto);
		sessionStatus.setComplete();
		return "redirect:/yshome/listAll";
	}
}
