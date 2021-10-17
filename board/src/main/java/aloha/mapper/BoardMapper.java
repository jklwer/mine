package aloha.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aloha.domain.Board;

@Mapper
public interface BoardMapper {

	//게시글 목록 
	public List<Board> list()throws Exception;

}
