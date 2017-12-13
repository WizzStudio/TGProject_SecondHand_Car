package com.tg.test;

import com.tg.util.ImageUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) throws ParseException {
		String pattern = "image.*";
		System.out.println(Pattern.matches(pattern, "image/jpeg"));
		String str = "1992/02/08";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = format.parse(str);
		System.out.println(date);

		String str1 = "guazi_0.jpg";
		String url = str1.split("_")[0]+".*";
		System.out.println(url);
//		String[] arr = str1.split("\\.");
//		System.out.println(arr[1]);
		System.out.println(Pattern.matches(url,"guazi_1.png"));

		String path = "target/SecondCar-0.0.1-SNAPSHOT/TG_Photo/";
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
		File[] list = file.listFiles();
		System.out.println(list.length);
		String pic = "http://119.23.75.180:8080/SecondCar/TG_Photo/IGS09651F94M_0.jpg";
		String fileName = pic.substring(pic.lastIndexOf('/')+1,pic.length());
		System.out.println(fileName);
		//ImageUtils.deleteFile(pic);

		String l = "1231312_0.jpg";
		String fn =l.split("_")[0];
		System.out.println(fn.equals("1231312_0.jpg".split("_")[0]));
	}
}
