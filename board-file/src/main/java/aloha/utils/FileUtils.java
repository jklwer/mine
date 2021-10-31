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
	 * �������� ���ε� 
	 * @param files
	 * @param uploadPath
	 * @return
	 * @throws Exception
	 */
		
	public List<BoardFile> uploadFiles(MultipartFile[] files, String uploadPath) throws Exception{
		
		ArrayList<BoardFile> fileList = new ArrayList<BoardFile>();
		
		//���ε� ��ο� ���� ����
		for (MultipartFile file : files) {
		
			//���� ���� ���� Ȯ��
			if(file.isEmpty()) continue;
			
			//	[��������]
			log.info("filename : " + file.getOriginalFilename());
			log.info("contentType : " + file.getContentType());
			log.info("size : " + file.getSize());
			
			//���ϸ� �ߺ� ������ ���� ���� id ����
			UUID uid = UUID.randomUUID();
			
			//���� ���� ���� �̸�
			String originalFileName = file.getOriginalFilename();
			
			//UID_������.png
			String uploadFileName = uid.toString() + "_" + originalFileName;
			
			//���ε� ������ ���ε� �� ���� ����
			byte[] fileData = file.getBytes();		
			File target = new File(uploadPath, uploadFileName);
				//fileData : ��û�� ����
				//target : ���ε� �� ���� ��ü
			
			//���� ����
			FileCopyUtils.copy(fileData, target);
			
			//���ε� �� ���� ��ü ��� (��� + �̸�)
			String uploadedPath = uploadPath + "/" + uploadFileName;
			
			BoardFile f = new BoardFile();
			f.setFullName(uploadedPath);
			f.setFileName(originalFileName);
			fileList.add(f);
		
		}
		return fileList;
	}
	
}
