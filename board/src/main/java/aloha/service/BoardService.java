package aloha.service;

import java.util.List;

import aloha.domain.Board;

public interface BoardService {

	//�Խñ� ��� 
	public List<Board> list() throws Exception;

	//�Խñ� ���� 
	public void insert(Board board) throws Exception;

	//�Խñ� �б�
	public Board read(Integer boardNo) throws Exception;

	//�Խñ� ����
	public void update(Board board) throws Exception;

	//�Խñ� ����
	public void delete(Integer boardNo) throws Exception;

	//�Խñ� �˻�
	public List<Board> list(String keyword) throws Exception;

	
}
