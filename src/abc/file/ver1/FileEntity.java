package abc.file.ver1;

public class FileEntity {
	private int id;
	private String writer, title, savedfilename, originalfilename;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getSavedfilename() {
		return savedfilename;
	}
	public void setSavedfilename(String savedFileName) {
		this.savedfilename = savedFileName;
	}
	public String getOriginalfilename() {
		return originalfilename;
	}
	public void setOriginalfilename(String originalFileName) {
		this.originalfilename = originalFileName;
	}
	
	
}
