package aloha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String list() throws Exception {
		
		//�Խñ� ��� ��û 
		List<Board> list = service.list();
		
		
		
		return "board/list";
	}
	
	
	//�Խñ� ���� - ȭ��(GET)
	//�Խñ� ���� - ó��(POST)
	
	//�Խñ� �б� - ȭ��(GET)
	
	//�Խñ� ���� - ȭ��(GET)
	//�Խñ� ���� - ó��(POST)

	//�Խñ� ���� - ó��(POST)
}

