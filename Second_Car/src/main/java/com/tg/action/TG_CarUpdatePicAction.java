package com.tg.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_CarupdateService;

public class TG_CarUpdatePicAction extends ActionSupport {
	@Autowired
	private TG_CarupdateService tcus;
	
	private static final String root="/TG_Photo";
	
	private int id;
	
	private File file;
	
	private String fileFileName;
	
	private String fileContentType;

	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String execute()throws Exception{
		
		System.out.println(file);
		System.out.println(fileFileName);
		System.out.println(fileContentType);
		//判断是否是图片
		String pattern = "image*";
		if(!Pattern.matches(pattern, fileContentType))
		{
			return ERROR;
		}
		String rootName=ServletActionContext.getServletContext().getRealPath(root);
		String relativePath=root+"/"+fileFileName;
//		System.out.println(rootName);
		File targetFile=new File(rootName,fileFileName);
		
		
		//FileUtils.copyFile(file, targetFile);
		InputStream fin=new FileInputStream(file);
		byte[] buff=new byte[1024];
		int len=fin.available();
//		System.out.println(len);
		OutputStream fou=new FileOutputStream(targetFile);
		while((len=fin.read(buff))>0){
			fou.write(buff, 0, len);
		}
		fin.close();                                                               
		fou.close();
		
		
		tcus.updatePic(relativePath, id);
//		System.out.println("success");
		return SUCCESS;
	}
}
