package aloha.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardFile {

	private int fileNo;			//���Ϲ�ȣ
	private int boardNo;		//�Խñ� ��ȣ
	private String fileName;	//���� �̸�
	private String fullName;	//���ϰ�� + �̸�
	private Date regDate;		//��� ����
	
}
