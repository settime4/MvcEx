package abc.file.ver1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileBdService {
	
	@Autowired private FileBdRepository fileBdRepository;
	
	public int saveFile(FileDomain fileDomain){
		//1. 파일 서버에 저장될 유일한 파일이름 생성
		//2. 파일 서버에 파일 저장
		//3.db에 저장할 엔티티 생성
		String originalFileName = fileDomain.getUpFile().getOriginalFilename();
		String savedFileName = FileUtil.makeSavedFileName(originalFileName);
		
        try {
	        boolean uploadResult = FileUtil.saveFile(savedFileName, fileDomain.getUpFile().getBytes());
			if(uploadResult){
				FileEntity fileEntity = new FileEntity();
				fileEntity.setTitle(fileDomain.getTitle());
				fileEntity.setOriginalfilename(originalFileName);
				fileEntity.setSavedfilename(savedFileName);
				fileEntity.setWriter(fileDomain.getWriter());
				
				return fileBdRepository.insert(fileEntity);
			}
        } catch (IOException e) {
	        e.printStackTrace();
        }
		return -1;
	}
	public List<FileModel> getFiles(){
		List<FileEntity> fileEntityList = fileBdRepository.selectAll();
		List<FileModel> fileModelList = new ArrayList<FileModel>();
		for (FileEntity fileEntity : fileEntityList) {
	        FileModel fileModel = new FileModel();
	        fileModel.setId(fileEntity.getId());
	        fileModel.setOriginalfilename(fileEntity.getOriginalfilename());
	        fileModel.setTitle(fileEntity.getTitle());
	        fileModel.setWriter(fileEntity.getWriter());
	        fileModelList.add(fileModel);
	        
        }
		return fileModelList;
	}
	public DownloadFile getDownloadFile(int id) {
		FileEntity fileEntity = fileBdRepository.selectById(id);
		File savedFile = FileUtil.getSavedFile(fileEntity.getSavedfilename());
		
		DownloadFile downloadFile = new DownloadFile();
		downloadFile.setFile(savedFile);
		downloadFile.setOriginalFileName(fileEntity.getOriginalfilename());
		
	    return downloadFile;
    }
	public int deleteFile(int id) {
		return fileBdRepository.delete(id);
    }
}
