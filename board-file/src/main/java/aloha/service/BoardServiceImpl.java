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

	//파일 경로
	@Value("${upload.path}")	//
	private String uploadPath;
	
	//파일 유틸
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
		
		//글쓰기 요청
		mapper.insert(board);
		
		//[파일 정보]
		MultipartFile[] files = board.getFile();

		//파일 업로드 (File)
		List<BoardFile> fileList = fileUtils.uploadFiles(files, uploadPath);
		
		//파일 업로드 (DB)
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
