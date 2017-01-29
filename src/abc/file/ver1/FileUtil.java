package abc.file.ver1;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class FileUtil {
 //파일 서버에 저장될 유일한 파일이름 생성
	private static final String uploadPath = "c:\\xyz\\upload";
	public static String makeSavedFileName(String originalFileName){
		UUID uid = UUID.randomUUID();
		String savedFile = uid.toString()+"_"+originalFileName;
		return savedFile;
	}

	public static boolean saveFile(String savedFileName, byte[] bytes) {
		
		File file = new File(uploadPath);
		if( ! file.exists()){
			file.mkdir();
		}
		try {
			File target = new File(uploadPath, savedFileName);
			FileCopyUtils.copy(bytes, target);
        } catch (IOException e) {
        	return false;
        }
		return true;
    }
	
	public static File getSavedFile(String savedFileName){
		File downloadFile = new File(uploadPath, savedFileName);
		return downloadFile;
	}
}
