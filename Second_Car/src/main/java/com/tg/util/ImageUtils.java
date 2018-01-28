package com.tg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.struts2.ServletActionContext;

public class ImageUtils {

	public static final String ROOT ="http://119.23.75.180:8080/SecondCar/TG_Photo";
	public  static final String PATH = "/TG_Photo";
	private static double SCALE = 0.5f;
	private  static double QUALITY = 0.5f;
	private static int WIDTH = 200;
	private static int HEIGHT = 200;

	//判断是否是图片
	public static boolean  isImage(String fileContentType)
	{
		String pattern = "image.*";
		if(!Pattern.matches(pattern, fileContentType))
		{
			return false;
		}else{
			return true;
		}
	}

	/*进行文件的拷贝*/
	public static void copyFile(String root,String fileFileName,File file)
	{
		String rootName=ServletActionContext.getServletContext().getRealPath(root);

		/**
		 * 使用google API对图片进行压缩
		 */

		File targetFile=new File(rootName,fileFileName);

		
		//FileUtils.copyFile(file, targetFile);
		InputStream fin = null;
		OutputStream fou = null;
		try {
			fin = new FileInputStream(file);
			byte[] buff=new byte[1024];
			int len;
			len = fin.available();
			fou =new FileOutputStream(targetFile);
			while((len=fin.read(buff))>0){
				fou.write(buff, 0, len);
			}
			if(targetFile.length()>40*1024){	//如果图片大小大于40kb，就压缩图片
				try {
					Thumbnails.of(targetFile)
							.scale(SCALE)
							.outputQuality(QUALITY)
							.toFile(targetFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(len);
			try {
				fin.close();
				fou.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                                                               
		
	}

	public static boolean deleteAllFile(String pic){
		String rootName = ServletActionContext.getServletContext().getRealPath(PATH);
		System.out.println(rootName);
		File file = new File(rootName);
		File[] tempFiles = file.listFiles();
		if(null==pic){
			return true;
		}
		String fileName = pic.substring(pic.lastIndexOf('/')+1,pic.length());
		for(File f:tempFiles){
			if(f.getName().split("_")[0].equals(fileName.split("_")[0])){
				f.delete();
			}else{
				continue;
			}
		}
		return true;
	}

	public static boolean deleteFile(String pic){
		String rootName = ServletActionContext.getServletContext().getRealPath(PATH);
		System.out.println(rootName);
		File file = new File(rootName);
		File[] tempFiles = file.listFiles();
		if(null==pic){
			return true;
		}
		String fileName = pic.substring(pic.lastIndexOf('/')+1,pic.length());
		for(File f:tempFiles){
			if(f.getName().split("\\.")[0].equals(fileName.split("\\.")[0])){
				f.delete();
			}else{
				continue;
			}
		}
		return true;
	}
	//文件重命名
	public static void renameFile(String pic,String newName)
	{
		String rootName = ServletActionContext.getServletContext().getRealPath(PATH);
		System.out.println(rootName);
		File file = new File(rootName);
		File[] tempFiles = file.listFiles();
		String fileName = pic.substring(pic.lastIndexOf('/')+1,pic.length());
		for(File f:tempFiles){
			if(f.getName().equals(fileName)){
				f.renameTo(new File(newName));
			}else{
				continue;
			}
		}
	}

}
