package aloha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String list() throws Exception {
		
		//게시글 목록 요청 
		List<Board> list = service.list();
		
		
		
		return "board/list";
	}
	
	
	//게시글 쓰기 - 화면(GET)
	//게시글 쓰기 - 처리(POST)
	
	//게시글 읽기 - 화면(GET)
	
	//게시글 수정 - 화면(GET)
	//게시글 수정 - 처리(POST)

	//게시글 삭제 - 처리(POST)
}

