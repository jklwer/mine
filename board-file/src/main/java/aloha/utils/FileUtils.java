package aloha.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import aloha.domain.BoardFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileUtils {
	
	/**
	 * 다중파일 업로드 
	 * @param files
	 * @param uploadPath
	 * @return
	 * @throws Exception
	 */
		
	public List<BoardFile> uploadFiles(MultipartFile[] files, String uploadPath) throws Exception{
		
		ArrayList<BoardFile> fileList = new ArrayList<BoardFile>();
		
		//업로드 경로에 파일 복사
		for (MultipartFile file : files) {
		
			//파일 존재 여부 확인
			if(file.isEmpty()) continue;
			
			//	[파일정보]
			log.info("filename : " + file.getOriginalFilename());
			log.info("contentType : " + file.getContentType());
			log.info("size : " + file.getSize());
			
			//파일명 중복 방지를 위한 고유 id 생성
			UUID uid = UUID.randomUUID();
			
			//실제 원본 파일 이름
			String originalFileName = file.getOriginalFilename();
			
			//UID_강아지.png
			String uploadFileName = uid.toString() + "_" + originalFileName;
			
			//업로드 폴더에 업로드 할 파일 복사
			byte[] fileData = file.getBytes();		
			File target = new File(uploadPath, uploadFileName);
				//fileData : 요청된 파일
				//target : 업로드 할 파일 객체
			
			//파일 복사
			FileCopyUtils.copy(fileData, target);
			
			//업로드 된 파일 전체 경로 (경로 + 이름)
			String uploadedPath = uploadPath + "/" + uploadFileName;
			
			BoardFile f = new BoardFile();
			f.setFullName(uploadedPath);
			f.setFileName(originalFileName);
			fileList.add(f);
		
		}
		return fileList;
	}
	
}
