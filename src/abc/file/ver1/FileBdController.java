package abc.file.ver1;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileBdController {
	
	@Autowired private FileBdService fileBdService; 
	
	@RequestMapping("/fileUpload_v1")
	public String uploadReady(){
		return "upload_v1";
	}
	
	@RequestMapping(value="/fileUpload_v1", method=RequestMethod.POST)
	public String uploadFile(@ModelAttribute FileDomain fileDomain){
		System.out.println(fileDomain.getUpFile().getOriginalFilename());
		System.out.println(fileDomain.getUpFile().getContentType());
		fileBdService.saveFile(fileDomain);
		return "redirect:/fileboard/fileList_v1";
	}

	@RequestMapping("/fileList_v1")
	@ModelAttribute("fileList")
	public List<FileModel> list(){
		return fileBdService.getFiles();
	}
	
	@RequestMapping(value="/download_v1", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody FileSystemResource download(@RequestParam int id, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException{
		DownloadFile downloadFile = fileBdService.getDownloadFile(id);
		
		String downName = null;
		String browser = request.getHeader("User-Agent");
		System.out.println(browser);
		
		if(browser.contains("Chrome") || browser.contains("MISE") || browser.contains("Trident")){
			downName =URLEncoder.encode(downloadFile.getOriginalFileName(), "UTF-8").replaceAll("\\+", "%20");
			response.setHeader("Content-Disposition", "attachment; filename="+downName+";");
		}else{
			downName =new String(downloadFile.getOriginalFileName().getBytes("utf-8"), "iso-8859-1").replaceAll("\\", "_");
			response.setHeader("Content-Disposition", "attachment; filename="+downName+";");
		}
		return new FileSystemResource(downloadFile.getFile());
	}
	
	@RequestMapping("delete")
	public String deleteFile(@RequestParam int id){
		DownloadFile downloadFile = fileBdService.getDownloadFile(id);
		File deleteFile = downloadFile.getFile();
		if(deleteFile.exists()){
			deleteFile.delete();
			fileBdService.deleteFile(id);
		}else{
			System.out.println("½ÇÆÐ");
		}
		return "redirect:/fileboard/fileList_v1";
	}
}
