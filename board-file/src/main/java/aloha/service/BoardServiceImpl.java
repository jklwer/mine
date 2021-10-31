package aloha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aloha.domain.Board;
import aloha.domain.BoardFile;
import aloha.mapper.BoardMapper;
import aloha.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

	//���� ���
	@Value("${upload.path}")	//
	private String uploadPath;
	
	//���� ��ƿ
	@Autowired
	private FileUtils fileUtils;
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<Board> list() throws Exception {
		
		return mapper.list();
	}

	@Override
	public void insert(Board board) throws Exception {
		
		//�۾��� ��û
		mapper.insert(board);
		
		//[���� ����]
		MultipartFile[] files = board.getFile();

		//���� ���ε� (File)
		List<BoardFile> fileList = fileUtils.uploadFiles(files, uploadPath);
		
		//���� ���ε� (DB)
		for (BoardFile file : fileList) {
			mapper.uploadFile(file);
		}
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		return mapper.read(boardNo);
	}

	@Override
	public void update(Board board) throws Exception {

		mapper.update(board);
	}

	@Override
	public void delete(Integer boardNo) throws Exception {
		mapper.delete(boardNo);
	}

	@Override
	public List<Board> list(String keyword) throws Exception {
		keyword = keyword == null ? "" : keyword;
		return mapper.search(keyword);
	}

}
