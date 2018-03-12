package com.portfolio.yshome.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.yshome.domain.BoardDTO;
import com.portfolio.yshome.domain.CriteriaDTO;
import com.portfolio.yshome.domain.FileDTO;
import com.portfolio.yshome.service.IBoardService;

@Controller
@RequestMapping("/yshome/*")
@SessionAttributes("id")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	ArrayList<FileDTO> list = new ArrayList<>();

	@Inject
	private IBoardService service;

	@Secured("ROLE_USER")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET(BoardDTO bDto, Model model) throws Exception {
		logger.info("register get.................");
		return "board/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardDTO bDto, RedirectAttributes rttr, Model model) throws Exception {
		logger.info("register post......................");
		logger.info(bDto.toString());
		
		// 게시글 저장
		service.regist(bDto);
		
		for (FileDTO fileDTO : list) {
			System.out.println("리스트 값 확인==============>" + fileDTO.toString());
		}
		// 파일 DB에 저장
		for (FileDTO fDto : list) {
			service.fileUpload(fDto);
		}
		rttr.addFlashAttribute("msg", "리다이렉트된 메세지 입니다.");
		model.addAttribute("result", "success");

		return "redirect:/yshome/listAll";
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<FileDTO> fileUpload(MultipartHttpServletRequest multipartRequest) throws Exception {
		logger.info("파일 업로드 준비");
		Iterator<String> itr = multipartRequest.getFileNames();
		String filesPath = "D:\\workspace-sts-3.9.1.RELEASE\\yshome\\src\\main\\webapp\\resources\\files\\"; // 파일

		while (itr.hasNext()) {

			MultipartFile mpf = multipartRequest.getFile(itr.next());
			String originalfilename = mpf.getOriginalFilename();

			File f = new File(filesPath, originalfilename);
			if (f.isFile()) {
				UUID uuid = UUID.randomUUID();
				originalfilename = uuid.toString() + "_" + originalfilename;
			}
			// 확장자명 추출
			StringTokenizer token = new StringTokenizer(originalfilename);
			String filename = token.nextToken(".");
			String filetype = token.nextToken(".");
			
			FileDTO fDto = new FileDTO();
			fDto.setFilename(filename);
			fDto.setFiletype(filetype);
			list.add(fDto);
			try {
				// 파일 저장
				mpf.transferTo(new File(filesPath + originalfilename));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public String comment(BoardDTO bDto, RedirectAttributes rttr) throws Exception {
		logger.info(bDto.toString());
		service.comment(bDto);
		rttr.addFlashAttribute("msg", "리다이렉트된 메세지 입니다.");
		/* model.addAttribute("result", "success"); */

		return "redirect:/yshome/listAll";
	}

	@RequestMapping("/listAll")
	public String listAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "perPageNum", defaultValue = "10") int perPageNum,
			@RequestParam(value = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(value = "searchType", defaultValue = "") String searchType, Model model) throws Exception {
		CriteriaDTO criDto = new CriteriaDTO(page, perPageNum, keyWord, searchType);
		criDto.setTotal(service.paperNum(criDto));
		model.addAttribute("lastpage", service.paperNum(criDto)); // 총 게시판 건수
		model.addAttribute("page", criDto);
		model.addAttribute("next", criDto.nextPage());
		model.addAttribute("prev", criDto.prevPage());
		model.addAttribute("list", service.listCriteria(criDto));
		boolean prev1 = ((criDto.getPage() - 1) / 10) != criDto.getTotal() / 10;
		model.addAttribute("prev1", prev1);

		System.out.println(criDto.toString());
		return "/board/listAll";
	}

	@RequestMapping("/detail")
	public String detail(@RequestParam("bno") Integer bno, @RequestParam("viewcnt") Integer viewcnt, Model model)
			throws Exception {
		BoardDTO vDto = new BoardDTO();
		vDto.setBno(bno);
		vDto.setViewcnt(viewcnt);
		service.detailcnt(vDto);
		model.addAttribute("listDetail", service.detail(bno, viewcnt));
		System.out.println(service.detail(bno, viewcnt));
		return "/board/boarddetail";
	}

	/*
	 * @RequestMapping("/next") public String detailnext(@RequestParam("bno") String
	 * bno1, Model model) throws Exception { System.out.println(bno1); int bno =
	 * Integer.parseInt(bno1); System.out.println(bno);
	 * model.addAttribute("listDetail", service.detail(bno)); return
	 * "board/boarddetail"; }
	 * 
	 * @RequestMapping("/prev") public String detailprev(@RequestParam("bno") String
	 * bno1, Model model) throws Exception { int bno = Integer.parseInt(bno1);
	 * System.out.println(bno1); model.addAttribute("listDetail",
	 * service.detail(bno)); return "board/boarddetail"; }
	 */

	@RequestMapping("/update_form")
	public String update(@RequestParam("writer") String writer, Model model) throws Exception {
		model.addAttribute("list", writer);
		return "/board/boardupdate";
	}

	@RequestMapping("/remove")
	public String remove(@RequestParam("bno") Integer bno) throws Exception {
		service.remove(bno);
		return "redirect:/yshome/listAll";
	}

	@RequestMapping(value = "/modify_form", method = RequestMethod.POST)
	public String modify_form(@RequestParam("bno") Integer bno, Model model) throws Exception {
		System.out.println(bno);
		model.addAttribute("listDetail", service.modify_form(bno));
		return "/board/boardmodify";
	}

	@RequestMapping("/modify")
	public String modify(@RequestParam("bno") Integer bno, BoardDTO bDto, RedirectAttributes rttr) throws Exception {
		bDto.setBno(bno);
		System.out.println(bDto);

		System.out.println(bDto.getBno());
		service.modify(bDto);
		rttr.addFlashAttribute("msg", "수정되었습니다.");
		return "redirect:/yshome/listAll";
	}

}
