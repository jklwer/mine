package aloha.domain;

import java.util.Date;

import lombok.Data;

@Data 	// getter@setter, toString()등의 메소드를 자동 생성 
public class Board {
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updDate;
}
