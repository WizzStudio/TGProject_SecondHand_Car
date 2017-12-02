package com.tg.util;

import java.util.List;

import com.tg.javabean.Page;

public class PageUtil {
	
	//创建页面
	
	public static  <T> Page<T> createPage(List<T> list,int totalCount,int everyPage,int currentPage)
	{
			int beginIndex = getBeginIndex(everyPage, currentPage);
			int totalPage = getTotalPage(totalCount, everyPage);
			boolean hasPrePage = getHasPrePage(currentPage);
			boolean hasNextPage = getHasNextPage(currentPage, totalPage);
			
			return new Page(everyPage, totalCount, currentPage, totalPage, beginIndex, hasPrePage, hasNextPage, list);
	}
	
	// 查询总页数
	public static int getTotalPage(int totalCount,int everyPage)
	{
		//everyPage不能为零
		return totalCount%everyPage==0?totalCount/everyPage:totalCount/everyPage+1;
	}
	//查询当前当前页的起始index 默认从1开始计数
	public static int getBeginIndex(int everyPage,int currentPage)
	{
		return (currentPage-1)*everyPage+1;
	}
	//查询是否有上一页
	public static boolean getHasPrePage(int currentPage)
	{
		//如果是第一页，则没有上一页
		return currentPage==1?false:true;
	}
	//查询是否有下一页
	public static boolean getHasNextPage(int currentPage,int totalPage)
	{
		return currentPage==totalPage?false:true;
	}
	
	//查询总记录数，根据list查询
	public static  <T> int getTotalCount(List<T> list)
	{
		return list.size();
	}

}
