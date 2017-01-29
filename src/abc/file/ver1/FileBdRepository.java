package abc.file.ver1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileBdRepository {
	
	@Autowired private FileMapper mapper;
	
	public int insert(FileEntity fileEntity){
		return mapper.save(fileEntity);
	}
	
	public List<FileEntity> selectAll(){
		return mapper.findAll();
	}
	
	public FileEntity selectById(int id){
		FileEntity fileEntity = mapper.findById(id);
		return fileEntity;
	}
	
	public int delete(int id){
		return mapper.remove(id);
	}
}
