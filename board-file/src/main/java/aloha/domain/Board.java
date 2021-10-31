package aloha.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data 	// getter@setter, toString()���� �޼ҵ带 �ڵ� ���� 
public class Board {
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updDate;

	private MultipartFile[] file;
}
