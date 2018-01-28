package com.tg.action;

import java.io.File;

import com.tg.service.TG_CarService;
import com.tg.util.TypeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.domain.TG_Car;
import com.tg.service.TG_CarupdateService;
import com.tg.util.ImageUtils;

public class TG_CarUpdateAllActioin extends ActionSupport{
	@Autowired
	private TG_CarupdateService tcs;
	@Autowired
	private TG_CarService tg_carService;
	private static final String PATH="/TG_Photo";
	private int id;
	private File pic;
	private String picFileName;
	private String picContentType;
	private File pic1;
	private String pic1FileName;
	private String pic1ContentType;
	private File pic2;
	private String pic2FileName;
	private String pic2ContentType;
	private File pic3;
	private String pic3FileName;
	private String pic3ContentType;
	private String brand;
	private String year;
	private String price;
	private String info;
	private String msg;
	private int code;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}
	

	public File getPic() {
		return pic;
	}


	public void setPic(File pic) {
		this.pic = pic;
	}


	public String getPicFileName() {
		return picFileName;
	}


	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}


	

	public String getPicContentType() {
		return picContentType;
	}


	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}

	public File getPic1() {
		return pic1;
	}

	public void setPic1(File pic1) {
		this.pic1 = pic1;
	}

	public String getPic1FileName() {
		return pic1FileName;
	}

	public void setPic1FileName(String pic1FileName) {
		this.pic1FileName = pic1FileName;
	}

	public String getPic1ContentType() {
		return pic1ContentType;
	}

	public void setPic1ContentType(String pic1ContentType) {
		this.pic1ContentType = pic1ContentType;
	}

	public File getPic2() {
		return pic2;
	}

	public void setPic2(File pic2) {
		this.pic2 = pic2;
	}

	public String getPic2FileName() {
		return pic2FileName;
	}

	public void setPic2FileName(String pic2FileName) {
		this.pic2FileName = pic2FileName;
	}

	public String getPic2ContentType() {
		return pic2ContentType;
	}

	public void setPic2ContentType(String pic2ContentType) {
		this.pic2ContentType = pic2ContentType;
	}

	public File getPic3() {
		return pic3;
	}

	public void setPic3(File pic3) {
		this.pic3 = pic3;
	}

	public String getPic3FileName() {
		return pic3FileName;
	}

	public void setPic3FileName(String pic3FileName) {
		this.pic3FileName = pic3FileName;
	}

	public String getPic3ContentType() {
		return pic3ContentType;
	}

	public void setPic3ContentType(String pic3ContentType) {
		this.pic3ContentType = pic3ContentType;
	}

	public String execute() throws Exception
	{
		TG_Car car =null;
		String[] arr,arr1,arr2,arr3;
		String fileName = "";
		String url = tg_carService.selectById(id).getPic();
		String fn = url.substring(45);
		String originFileName = fn.substring(fn.lastIndexOf('/')+1,fn.length());
		int y = Integer.parseInt(year);
		if(!TypeUtils.isYear(y))	//判断年份是否输入正确
		{
			msg = "年份错误";
			code = 0;
			return ERROR;
		}
		if(null==url)
		{
			msg = "没有更新的车辆信息";
			code = 0;
			return ERROR;
		}
		if(null!=pic) {
			if (!ImageUtils.isImage(picContentType)) {
				msg = "文件类型不对";
				code = 0;
				return ERROR;
			}
			ImageUtils.deleteFile(fn);
			arr= picFileName.split("\\.");
			/*如果其他三个图片有一个没有改变，戝将原来图片的名称改为第一个改过图片的名称*/
			if(null==pic1||null==pic2||null==pic3){
				arr[0] = originFileName.split("_")[0];
			}
			picFileName = arr[0] + "_0." + arr[1];
			fileName = arr[0];
			String picPath = ImageUtils.ROOT + "/" + picFileName;
			double p = Double.parseDouble(price);
			car = new TG_Car(picPath, brand, y, p, info);
			ImageUtils.copyFile(PATH, picFileName, pic);
			if(tcs.updateAll(car, id)){
				code =1;
				msg = "更新成功";
			}else {
				code = 0;
				msg = "更新失败";
				return ERROR;
			}

		}else{
			fileName = tg_carService.selectById(id).getPic().substring(45).split("_")[0];
		}
		if(null!=pic1){
			String deleteUrl = url.substring(url.lastIndexOf('/')+1).split("_")[0]+"_1.jpg";
			ImageUtils.deleteFile(deleteUrl);
			arr= fn.split("_");
			arr1 = pic1FileName.split("\\.");
			pic1FileName = arr[0]+"_1."+arr1[1];
			ImageUtils.copyFile(PATH, pic1FileName, pic1);
		}else{
			String tmp = url.substring(45).split("_")[0]+"_1";
			ImageUtils.renameFile(tmp,fileName+"_1");
		}
		if(null!=pic2){
			String deleteUrl = url.substring(url.lastIndexOf('/')+1).split("_")[0]+"_2.jpg";
			ImageUtils.deleteFile(deleteUrl);
			arr= fn.split("_");
			arr2 = pic2FileName.split("\\.");
			pic2FileName = arr[0]+"_2."+arr2[1];
			ImageUtils.copyFile(PATH, pic2FileName, pic2);
		}else{
			String tmp = url.substring(45).split("_")[0]+"_2";
			ImageUtils.renameFile(tmp,fileName+"_2");
		}
		if(null!=pic3){
			String deleteUrl = url.substring(url.lastIndexOf('/')+1).split("_")[0]+"_3.jpg";
			ImageUtils.deleteFile(deleteUrl);
			arr= fn.split("_");
			arr3 = pic3FileName.split("\\.");
			pic3FileName = arr[0]+"_3."+arr3[1];
			ImageUtils.copyFile(PATH, pic3FileName, pic3);
		}else{
			String tmp = url.substring(45).split("_")[0]+"_3";
			ImageUtils.renameFile(tmp,fileName+"_3");
		}
		code = 1;
		msg = "更新成功";
		return SUCCESS;
	}
}
