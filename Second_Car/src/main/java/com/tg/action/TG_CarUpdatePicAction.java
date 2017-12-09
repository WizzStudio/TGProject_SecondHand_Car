package com.tg.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_CarupdateService;
import com.tg.util.ImageUtils;

public class TG_CarUpdatePicAction extends ActionSupport {
	@Autowired
	private TG_CarupdateService tcus;
	
	private static final String PATH="http://119.23.75.180:8080/SecondCar";
	private static final String root="/TG_Photo";
	
	private int id;
	
	private File file;
	
	private String fileFileName;
	
	private String fileContentType;
	
	private int code;
	private String msg;

	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
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
		
		//判断是否是图片
		String pattern = "image.*";
		if(!Pattern.matches(pattern, fileContentType))
		{
			code = 0;
			msg = "图片类型不正确";
			return ERROR;
		}
		String relativePath=PATH+root+"/"+fileFileName;
		ImageUtils.copyFile(root, fileFileName, file);
		tcus.updatePic(relativePath, id);
//		System.out.println("success");
		code = 1;
		msg = "更新成功";
		return SUCCESS;
	}
}
