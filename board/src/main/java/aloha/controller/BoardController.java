package aloha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import aloha.domain.Board;
import aloha.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j	//lombok 로그
@Controller
@RequestMapping("/board")	//상위경로
public class BoardController {

	//의존성 주입 (DI)
	//제어의 역전 (IoC)
	
	@Autowired			//의존성 자동 주입 어노테이션
	private BoardService service;
	
	//게시글 목록(GET)
	@GetMapping("/list")	//상위경로board
	public String list(Model model) throws Exception {
		
		//게시글 목록 요청 
		List<Board> list = service.list();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	
	//게시글 쓰기 - 화면(GET)
	@GetMapping("/insert")
	public String insertForm(Model model, Board board) throws Exception{
		return "board/insert";
	}
	
	
	//게시글 쓰기 - 처리(POST)
	@PostMapping("/insert")
	public String insert(Model model, Board board) throws Exception{
		
		//게시글 쓰기 요청
		service.insert(board);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		return "board/success";
	}
	
	
	//게시글 읽기 - 화면(GET)
	@GetMapping("/read")
	public String read(Model model, Integer boardNo) throws Exception{
		
		//게시글 읽기 요청
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		
		return "board/read";
		
	}
	
	
	//게시글 수정 - 화면(GET)
	@GetMapping("/update")
	public String updateForm(Model model, Integer boardNo) throws Exception{
		//게시글 읽기 요청
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		
		return "board/update";
	}
	
	
	//게시글 수정 - 처리(POST)
	@PostMapping("/update")
	public String update(Model model, Board board) throws Exception{
		
		//게시글 수정 요청
		service.update(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		
		return "board/success";
	}

	//게시글 삭제 - 처리(POST)
	@PostMapping("/delete")
	public String delete(Model model, Integer boardNo) throws Exception{
		
		//게시글 삭제 요청
		service.delete(boardNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		
		return "board/success";
	}
	
	
	
	
	
	
	
	
	
	
	
}

