package aloha.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aloha.domain.Board;

@Mapper
public interface BoardMapper {

	//�Խñ� ��� 
	public List<Board> list()throws Exception;
	//�Խñ� ����
	public void insert(Board board) throws Exception;
	//�Խñ� �б�
	public Board read(Integer boardNo) throws Exception;
	public void update(Board board);
	public void delete(Integer boardNo);

}
