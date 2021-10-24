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

@Slf4j	//lombok �α�
@Controller
@RequestMapping("/board")	//�������
public class BoardController {

	//������ ���� (DI)
	//������ ���� (IoC)
	
	@Autowired			//������ �ڵ� ���� ������̼�
	private BoardService service;
	
	//�Խñ� ���(GET)
	@GetMapping("/list")	//�������board
	public String list(Model model) throws Exception {
		
		//�Խñ� ��� ��û 
		List<Board> list = service.list();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	
	//�Խñ� ���� - ȭ��(GET)
	@GetMapping("/insert")
	public String insertForm(Model model, Board board) throws Exception{
		return "board/insert";
	}
	
	
	//�Խñ� ���� - ó��(POST)
	@PostMapping("/insert")
	public String insert(Model model, Board board) throws Exception{
		
		//�Խñ� ���� ��û
		service.insert(board);
		model.addAttribute("msg", "����� �Ϸ�Ǿ����ϴ�.");
		
		return "board/success";
	}
	
	
	//�Խñ� �б� - ȭ��(GET)
	@GetMapping("/read")
	public String read(Model model, Integer boardNo) throws Exception{
		
		//�Խñ� �б� ��û
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		
		return "board/read";
		
	}
	
	
	//�Խñ� ���� - ȭ��(GET)
	@GetMapping("/update")
	public String updateForm(Model model, Integer boardNo) throws Exception{
		//�Խñ� �б� ��û
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		
		return "board/update";
	}
	
	
	//�Խñ� ���� - ó��(POST)
	@PostMapping("/update")
	public String update(Model model, Board board) throws Exception{
		
		//�Խñ� ���� ��û
		service.update(board);
		model.addAttribute("msg", "������ �Ϸ�Ǿ����ϴ�.");
		
		return "board/success";
	}

	//�Խñ� ���� - ó��(POST)
	@PostMapping("/delete")
	public String delete(Model model, Integer boardNo) throws Exception{
		
		//�Խñ� ���� ��û
		service.delete(boardNo);
		model.addAttribute("msg", "������ �Ϸ�Ǿ����ϴ�.");
		
		return "board/success";
	}
	
	
	
	
	
	
	
	
	
	
	
}

