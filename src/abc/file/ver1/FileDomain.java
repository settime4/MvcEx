package abc.file.ver1;

import org.springframework.web.multipart.MultipartFile;

public class FileDomain {
	
	private String writer;
	private String title;
	private MultipartFile upFile;
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getUpFile() {
		return upFile;
	}
	public void setUpFile(MultipartFile upFile) {
		this.upFile = upFile;
	}
	
}
