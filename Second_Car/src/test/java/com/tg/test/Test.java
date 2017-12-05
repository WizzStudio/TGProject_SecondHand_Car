package com.tg.test;

import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String pattern = "image.*";
		System.out.println(Pattern.matches(pattern, "image/jpeg"));
	}
}
