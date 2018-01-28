package com.tg.util;

/**
 * 进行类型转换、以及常用判断的工具类
 */
public class TypeUtils {
    public static boolean isYear(int year){
        if(year>1000&&year<3000)
        {
            return true;
        }else{
            return false;
        }
    }
}
