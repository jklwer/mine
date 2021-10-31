package aloha.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardFile {

	private int fileNo;			//파일번호
	private int boardNo;		//게시글 번호
	private String fileName;	//파일 이름
	private String fullName;	//파일경로 + 이름
	private Date regDate;		//등록 일자
	
}
