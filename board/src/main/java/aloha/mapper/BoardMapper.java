package aloha.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aloha.domain.Board;

@Mapper
public interface BoardMapper {

	//�Խñ� ��� 
	public List<Board> list()throws Exception;

}
