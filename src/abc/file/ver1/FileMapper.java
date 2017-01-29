package abc.file.ver1;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface FileMapper {
	
	@Insert("insert into filebd values(#{id}, #{writer}, #{title} , #{savedfilename}, #{originalfilename})")
	@SelectKey(statement="select filebd_seq.nextval from dual", before=true, resultType=int.class, keyProperty="id")
	public int save(FileEntity fileEntity);
	
	@Select("select id, writer, title, originalfilename from filebd")
	public List<FileEntity> findAll();
	
	@Select("select * from filebd where id=#{id}")
	public FileEntity findById(int id);
	
	@Delete("delete from filebd where id=#{id}")
	public int remove(int id);
}
