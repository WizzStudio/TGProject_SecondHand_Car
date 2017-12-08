package com.tg.test;

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
	}
}
