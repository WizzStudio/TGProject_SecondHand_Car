package com.tg.action;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarService;
import com.tg.util.ImageUtils;

public class TG_CarAddAction extends ActionSupport {
	@Autowired
	private TG_CarService tcs;
	private static final String ROOT ="http://119.23.75.180:8080/SecondCar/TG_Photo";
	private static final String PATH="/TG_Photo";

	
	private int cid;
	private String brand;
	private int year;
	private double price;
	private String info;
	
	private File file;
	private String fileFileName;
	private String fileContentType;

	private File file1;
	private String file1FileName;
	private String file1ContentType;

	private File file2;
	private String file2FileName;
	private String file2ContentType;

	private File file3;
	private String file3FileName;
	private String file3ContentType;

	//需要返回的值
	private int code=0;	//添加成功的状态
	private String msg="请选择图片";	//添加成功的返回信息
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
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

	public File getFile1() {
		return file1;
	}

	public void setFile1(File file1) {
		this.file1 = file1;
	}

	public String getFile1FileName() {
		return file1FileName;
	}

	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}

	public String getFile1ContentType() {
		return file1ContentType;
	}

	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	public File getFile2() {
		return file2;
	}

	public void setFile2(File file2) {
		this.file2 = file2;
	}

	public String getFile2FileName() {
		return file2FileName;
	}

	public void setFile2FileName(String file2FileName) {
		this.file2FileName = file2FileName;
	}

	public String getFile2ContentType() {
		return file2ContentType;
	}

	public void setFile2ContentType(String file2ContentType) {
		this.file2ContentType = file2ContentType;
	}

	public File getFile3() {
		return file3;
	}

	public void setFile3(File file3) {
		this.file3 = file3;
	}

	public String getFile3FileName() {
		return file3FileName;
	}

	public void setFile3FileName(String file3FileName) {
		this.file3FileName = file3FileName;
	}

	public String getFile3ContentType() {
		return file3ContentType;
	}

	public void setFile3ContentType(String file3ContentType) {
		this.file3ContentType = file3ContentType;
	}

	public String execute()throws Exception{
		System.out.println(fileFileName);
		System.out.println(fileContentType);
		String[] arr = fileFileName.split("\\.");
		fileFileName = arr[0]+"_0."+arr[1];
		String url = ROOT+"/"+fileFileName;
		if(!ImageUtils.isImage(fileContentType)){
			code = 0;
			msg="文件类型错误";
			return ERROR;
		}

		TG_Car car = new TG_Car(url, brand, year, price, info);
		ImageUtils.deleteAllFile(url);
		if(tcs.add(car))
		{
			String[] arr1 = file1FileName.split("\\.");
			file1FileName = arr[0]+"_1."+arr1[1];
			String[] arr2 = file2FileName.split("\\.");
			file2FileName = arr[0]+"_2."+arr2[1];
			String[] arr3 = file3FileName.split("\\.");
			file3FileName = arr[0]+"_3."+arr3[1];
			ImageUtils.copyFile(PATH, fileFileName, file);
			ImageUtils.copyFile(PATH, file1FileName, file1);
			ImageUtils.copyFile(PATH, file2FileName, file2);
			ImageUtils.copyFile(PATH, file3FileName, file3);
			//添加成功
			code = 1;
			msg = "添加成功";
			return SUCCESS;
		}else{
			code =0 ;
			msg = "添加失败";
			return ERROR;
		}
		
	}
}
